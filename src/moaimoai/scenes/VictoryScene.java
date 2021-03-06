package moaimoai.scenes;

import bases.GameObject;
import bases.renderers.ImageRenderer;
import moaimoai.GameWindow;
import moaimoai.audio.AudioManager;
import moaimoai.inputs.InputHandler;
import moaimoai.inputs.InputManager;
import moaimoai.settings.Settings;
import tklibs.AudioUtils;

import java.awt.event.KeyEvent;

/**
 * Created by NguyenGiaThe on 9/9/2017.
 */
public class VictoryScene extends Scene {
    @Override
    public void init() {
        GameObject.stop = false;
        ImageRenderer imageRenderer = ImageRenderer.create("assets/images/21476098_503750036625795_1648979409_n.png");
        GameObject background = new GameObject().setRenderer(imageRenderer);
        background.getPosition().set(Settings.instance.getGamePlayWidth() / 2, Settings.instance.getGamePlayHeight() / 2);
        GameObject.add(background);

        this.inputHandler = new InputHandler() {
            @Override
            public void KeyPressed(KeyEvent e) {
            }

            @Override
            public void KeyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    SceneManager.changeScene(new GamePlay());
                    GameWindow.setPlayerHP(3);
                }
            }
        };
        InputManager.instance.register(this);
        AudioManager.register(AudioUtils.playMedia("assets/music/bgm/SAD-MUSIC-_2.wav"));
    }
}
