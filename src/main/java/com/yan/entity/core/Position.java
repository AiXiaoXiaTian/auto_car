package com.yan.entity.core;

public class Position {
    private int positionX;
    private int positionY;

    public int getPositionX(){
        return positionX;
    }

    public int getPositionY(){
        return positionY;
    }

    public void setPosition(int x,int y){
        this.positionX = x;
        this.positionY = y;
    }

    public Position() {
    }

    public Position(int x,int y){
        this.positionX = x;
        this.positionY = y;
    }

    @Override
    public String toString() {
        return "(" + getPositionX() + "," + getPositionY() + ")";
    }


    public Position copy(){
        return new Position(this.positionX,this.positionY);
    }
}