package com.mycompany.a4;

public interface ICollider {
	public boolean collidesWith (GameObject otherObject);
	public void handleCollision(Alien otherObj, GameObjectCollection allAiGameObj, GameWorld gw);
}
