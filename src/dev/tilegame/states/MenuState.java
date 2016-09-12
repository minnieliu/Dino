package dev.tilegame.states;

import dev.tilegame.Game;
import dev.tilegame.Handler.Handler;
import dev.tilegame.UI.ClickListener;
import dev.tilegame.UI.UIManager;
import dev.tilegame.UI.UIImageButton;
import dev.tilegame.gfx.Assets;

import java.awt.*;

/**
 * Created by Minnie on 2016-07-10.
 */
public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(final Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObjects(new UIImageButton(800/2 - 100, 600/2 - 30, 200, 60, Assets.button_start, new ClickListener() {
            // creating an instance of the clickListener class on the fly
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));

    }
    @Override
    public void tick() {
       // System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
        uiManager.toString();
    }

    public UIManager getUiManager(){
        return uiManager;
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

    }
}
