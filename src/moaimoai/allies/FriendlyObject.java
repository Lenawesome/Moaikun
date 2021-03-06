package moaimoai.allies;

import bases.GameObject;
import bases.Vector2D;
import bases.physics.BoxCollider;
import bases.physics.Physics;
import bases.physics.PhysicsBody;
import bases.platforms.Platform;


public class FriendlyObject extends GameObject implements PhysicsBody{
    private BoxCollider boxCollider;
    private Vector2D velocity;
    private static int ALLYNUMBER = 0;
    private boolean isAlly;

    private AllyAnimator allyAnimator;
    public FriendlyObject(){
        super();
        boxCollider = new BoxCollider(30,30);
        this.allyAnimator = new AllyAnimator();
        this.renderer = allyAnimator;
        this.children.add(boxCollider);
        this.velocity = new Vector2D();
        this.isAlly = true;
    }

//    public static FriendlyObject creat(int friendlyObjectType) {
//        FriendlyObject friendlyObject = new FriendlyObject();
//        switch (friendlyObjectType) {
//            case 19:
//                friendlyObject.renderer = new Animation(5, false, false,
//                        SpriteUtils.loadImage("assets/images/peoples/pink/1.png"),
//                        SpriteUtils.loadImage("assets/images/peoples/pink/2.png"),
//                        SpriteUtils.loadImage("assets/images/peoples/pink/3.png"),
//                        SpriteUtils.loadImage("assets/images/peoples/pink/4.png"),
//                        SpriteUtils.loadImage("assets/images/peoples/pink/5.png")
//                );
//                friendlyObject.isAlly = true;
//                break;
//            case 2:
//                friendlyObject.renderer = ImageRenderer.create("assets/images/items/bombs/blue.png");
//                friendlyObject.isBomb = true;
//                break;
//        }
//        return friendlyObject;
//    }
    public static FriendlyObject create (){
        FriendlyObject friendlyObject = new FriendlyObject();
        return friendlyObject;
    }

    public static int getAllynumber() {
        return ALLYNUMBER;
    }

    public static void setAllynumber(int allynumber) {
        ALLYNUMBER = allynumber;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        velocity.y += 0.5;
        moveVertical();
        position.addUp(velocity);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }


    private void moveVertical() {
        float deltaY = velocity.y > 0 ? 1: -1;
        PhysicsBody body = Physics.collideWith(screenPosition,position.add(0, velocity.y), boxCollider.getWidth(), boxCollider.getHeight(),
                Platform.class);
        if (body != null) {
            while(Physics.collideWith(screenPosition,position.add(0, deltaY), boxCollider.getWidth(), boxCollider.getHeight(), Platform.class) == null) {
                position.addUp(0, deltaY);
            }
            this.velocity.y = 0;
        }
    }

//    public void getHit(){
//        EnemyRabit enemy = Physics.collideWith(this.boxCollider, EnemyRabit.class);
//        if (enemy != null){
//            this.isActive = false;
//            Explosion explosion = new Explosion();
//            explosion.setPosition(this.position);
//            GameObject.add(explosion);
//        }
//    }
    public boolean isAlly() {
        return isAlly;
    }
}
