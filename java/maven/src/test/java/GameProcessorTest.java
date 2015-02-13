import armor.Armor;
import armor.NoArmor;
import armor.SoldierArmor;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import player.OrdinaryPlayer;
import player.Player;
import player.Soldier;
import weapon.*;

import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * Created by zhl on 15/2/11.
 */
public class GameProcessorTest {

    private PrintStream out;
    private GameProcessor game;
    private Weapon stick;
    private Armor armor;
    private Weapon noWeapon;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
        stick = new Stick();
        armor = new SoldierArmor("铠甲", 4);
        noWeapon = new NoWeapon();
    }

    @Test
    public void should_print_lisi_is_defeated() {
        Player player1 = new OrdinaryPlayer(out, "张三", 20, 8);
        Player player2 = new OrdinaryPlayer(out, "李四", 10, 9);
        game = new GameProcessor(out, player1, player2);

        game.start();

        verify(out).println("李四被打败了");
    }

    @Test
    public void should_print_zhangsan_is_defeated_when_canAttack_of_zhangsan_is_false() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player1.getName()).willReturn("张三");
        given(player1.canAttack()).willReturn(false);

        game.start();

        verify(out).println("张三被打败了");
    }

    @Test
    public void should_print_zhangsan_is_defeated_when_run_3_rounds() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player1.getName()).willReturn("张三");
        given(player1.canAttack()).willReturn(true, true, false);
        given(player2.canAttack()).willReturn(true);
        game.start();

        verify(out).println("张三被打败了");
    }

    @Test
    public void should_print_lisi_is_defeated_when_run_3_rounds() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player2.getName()).willReturn("李四");
        given(player1.canAttack()).willReturn(true);
        given(player2.canAttack()).willReturn(true, true, false);
        game.start();

        verify(out).println("李四被打败了");
    }

    @Test
    public void should_print_zhangsan_is_defeated_process() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);

        given(player1.canAttack()).willReturn(true, true, false);
        given(player2.canAttack()).willReturn(true);
        given(player1.getName()).willReturn("张三");
        game.start();

        InOrder inOrder = inOrder(player1, player2, out);
        inOrder.verify(player1).attack(player2);
        inOrder.verify(player2).attack(player1);
        inOrder.verify(player1).attack(player2);
        inOrder.verify(player2).attack(player1);
        inOrder.verify(out).println("张三被打败了");
    }

    @Test
    public void should_print_lisi_is_defeated_process() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);

        given(player1.canAttack()).willReturn(true);
        given(player2.canAttack()).willReturn(true, true, true, true, true, true, false);
        given(player2.getName()).willReturn("李四");
        game.start();

        InOrder inOrder = inOrder(player1, player2, out);
        inOrder.verify(player1).attack(player2);
        inOrder.verify(player2).attack(player1);
        inOrder.verify(player1).attack(player2);
        inOrder.verify(player2).attack(player1);
        inOrder.verify(player1).attack(player2);
        inOrder.verify(player2).attack(player1);
        inOrder.verify(out).println("李四被打败了");
    }

    @Test
    public void should_print_ordinary_attack_ordinary() {
        Player player1 = new OrdinaryPlayer(out, "张三", 10, 8);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);

        verify(out).println("普通人张三攻击了普通人李四,李四受到了8点伤害,李四剩余生命:12");
    }

    @Test
    public void should_print_ordinary_attack_armored_soldier() {
        Player player1 = new OrdinaryPlayer(out, "张三", 10, 8);
        Player player2 = new Soldier(out, "李四", 20, 9, stick, armor);

        player1.attack(player2);

        verify(out).println("普通人张三攻击了战士李四,李四受到了4点伤害,李四剩余生命:16");
    }

    @Test
    public void should_print_ordinary_attack_not_armored_soldier() {
        Player player1 = new OrdinaryPlayer(out, "张三", 10, 8);
        Player player2 = new Soldier(out, "李四", 20, 9, stick, new NoArmor());

        player1.attack(player2);

        verify(out).println("普通人张三攻击了战士李四,李四受到了8点伤害,李四剩余生命:12");
    }

    @Test
    public void should_print_used_weapon_soldier_attack_ordinary_player() {
        Player player1 = new Soldier(out, "李四", 20, 9, stick, new NoArmor());
        Player player2 = new OrdinaryPlayer(out, "张三", 10, 8);

        player1.attack(player2);

        verify(out).println("战士李四用优质木棒攻击了普通人张三,张三受到了13点伤害,张三剩余生命:-3");
    }

    @Test
    public void should_print_used_weapon_soldier_attack_not_armored_soldier() {
        Player player1 = new Soldier(out, "李四", 20, 9, stick, new NoArmor());
        Player player2 = new Soldier(out, "张三", 10, 8, stick, new NoArmor());

        player1.attack(player2);

        verify(out).println("战士李四用优质木棒攻击了战士张三,张三受到了13点伤害,张三剩余生命:-3");
    }

    @Test
    public void should_print_used_weapon_soldier_attack_armored_soldier() {
        Player player1 = new Soldier(out, "李四", 20, 9, stick, new NoArmor());
        Player player2 = new Soldier(out, "张三", 10, 8, stick, armor);

        player1.attack(player2);

        verify(out).println("战士李四用优质木棒攻击了战士张三,张三受到了9点伤害,张三剩余生命:1");
    }

    @Test
    public void should_print_not_used_weapon_soldier_attack_ordinary_player() {
        Player player1 = new Soldier(out, "李四", 20, 9, new NoWeapon(), new NoArmor());
        Player player2 = new OrdinaryPlayer(out, "张三", 10, 8);

        player1.attack(player2);

        verify(out).println("战士李四攻击了普通人张三,张三受到了9点伤害,张三剩余生命:1");
    }

    @Test
    public void should_print_not_used_weapon_soldier_attack_not_armored_soldier() {
        Player player1 = new Soldier(out, "李四", 20, 9, new NoWeapon(), new NoArmor());
        Player player2 = new Soldier(out, "张三", 10, 8, stick, new NoArmor());

        player1.attack(player2);

        verify(out).println("战士李四攻击了战士张三,张三受到了9点伤害,张三剩余生命:1");
    }

    @Test
    public void should_print_not_used_weapon_soldier_attack_armored_soldier() {
        Player player1 = new Soldier(out, "李四", 20, 9, new NoWeapon(), new NoArmor());
        Player player2 = new Soldier(out, "张三", 10, 8, stick, armor);

        player1.attack(player2);

        verify(out).println("战士李四攻击了战士张三,张三受到了5点伤害,张三剩余生命:5");
    }

    @Test
    public void should_player_not_attack_when_player_can_not_attack() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player2.getName()).willReturn("李四");
        given(player1.canAttack()).willReturn(true);
        given(player2.canAttack()).willReturn(true, false);

        game.start();

        InOrder inOrder = inOrder(player1, player2, out);
        inOrder.verify(player1).attack(player2);
        inOrder.verify(player2, never()).attack(player1);
        inOrder.verify(out).println("李四被打败了");
    }

    @Test
    public void should_return_attacked_point_is_zero_when_defence_point_is_more_than_attacked_point() {
        Player player1 = new OrdinaryPlayer(out, "张三", 10, 3);
        Player player2 = new Soldier(out, "李四", 20, 9, new NoWeapon(), armor);

        player1.attack(player2);

        verify(out).println("普通人张三攻击了战士李四,李四受到了0点伤害,李四剩余生命:20");
    }

    @Test
    public void should_print_attacked_player_is_poison_when_attack_player_use_poison_sword() {
        Player player1 = new Soldier(out, "张三", 10, 8, new PoisonSword(), armor);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);

        verify(out).println("战士张三用毒剑攻击了普通人李四,李四受到了8点伤害,李四中毒了,李四剩余生命:12");

    }

    @Test
    public void should_print_harm_point_when_poisoned_player_attack() {
        Player player1 = new Soldier(out, "张三", 10, 8, new PoisonSword(), armor);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);
        player2.attack(player1);

        InOrder inOrder = inOrder(out);
        verify(out).println("战士张三用毒剑攻击了普通人李四,李四受到了8点伤害,李四中毒了,李四剩余生命:12");
        verify(out).println("李四受到2点毒性伤害,李四剩余生命:10");

    }

    @Test
    public void should_print_attacked_player_is_fired_when_attack_player_use_ice_sword() {
        Player player1 = new Soldier(out, "张三", 10, 8, new FireSword(), armor);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);

        verify(out).println("战士张三用火焰剑攻击了普通人李四,李四受到了8点伤害,李四着火了,李四剩余生命:12");

    }

    @Test
    public void should_print_harm_point_when_fired_player_attack() {
        Player player1 = new Soldier(out, "张三", 10, 8, new FireSword(), armor);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);
        player2.attack(player1);

        InOrder inOrder = inOrder(out);
        verify(out).println("战士张三用火焰剑攻击了普通人李四,李四受到了8点伤害,李四着火了,李四剩余生命:12");
        verify(out).println("李四受到2点火焰伤害,李四剩余生命:10");

    }

    @Test
    public void should_print_attacked_player_is_frozen_when_attack_player_use_ice_sword() {
        Player player1 = new Soldier(out, "张三", 10, 8, new IceSword(), armor);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);

        verify(out).println("战士张三用寒冰剑攻击了普通人李四,李四受到了8点伤害,李四冻僵了,李四剩余生命:12");
    }

    @Ignore
    public void should_print_miss_when_frozen_player_attack() {
        Player player1 = new Soldier(out, "张三", 10, 8, new IceSword(), armor);
        Player player2 = new OrdinaryPlayer(out, "李四", 20, 9);

        player1.attack(player2);
        player2.attack(player1);

        InOrder inOrder = inOrder(out);
        verify(out).println("战士张三用火焰剑攻击了普通人李四,李四受到了8点伤害,李四着火了,李四剩余生命:12");
        verify(out).println("李四受到2点火焰伤害,李四剩余生命:10");

    }
}
