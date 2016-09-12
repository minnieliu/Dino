package dev.tilegame.states;

import dev.tilegame.Entities.creatures.Player;
import dev.tilegame.Handler.Handler;
import dev.tilegame.UI.ClickListener;
import dev.tilegame.UI.UIImageButton;
import dev.tilegame.UI.UIManager;
import dev.tilegame.Worlds.World;
import dev.tilegame.gfx.Assets;

import java.awt.*;

/**
 * Created by Minnie on 2016-07-16.
 */
public class EndState extends State {

    private UIManager uiManager;

    public EndState(final Handler handler) {

        super(handler);
        uiManager = new UIManager(handler);
        if (handler.getWorld().getEntityManager().getPlayer().getScore() > 20) {
            handler.getMouseManager().setUIManager(uiManager);
            uiManager.addObjects(new UIImageButton(800 / 2 - 100, 600 / 2 - 30, 200, 60, Assets.button_start, new ClickListener() {
                // creating an instance of the clickListener class on the fly
                @Override
                public void onClick() {
                    State.setState(handler.getGame().menuState);

                }
            }));
        }
    }


    @Override
    public void tick() {
        uiManager.toString();

    }

    public UIManager getUIManager(){
        return uiManager;
    }

    @Override
    public void render(Graphics g) {

        uiManager.render(g);

        String steps = Integer.toString(handler.getWorld().getEntityManager().getPlayer().getStepCount()/20);
        Font font1 = new Font("Cooper Black", Font.BOLD, 20);
        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString("You've Cleared the Field in " + steps + " steps!", 200+2, 250+2);
        g.setColor(new Color(31, 31, 153));
        g.drawString("You've Cleared the Field in " + steps + " steps!", 200, 250);
        g.drawImage(Assets.player_down[0],350,300,null);

    }
}
