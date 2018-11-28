package pl.edu.agh.cs.to2.Model;

public enum Direction {
        LEFT,RIGHT,UP,DOWN;



        public Direction turnRight(){
            switch (this){
                case UP:
                    return RIGHT;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case RIGHT:
                    return DOWN;
                default:
                    return null;
            }
        }

        public Direction turnLeft(){
            switch (this){
                case UP:
                    return LEFT;
                case DOWN:
                    return RIGHT;
                case LEFT:
                    return DOWN;
                case RIGHT:
                    return UP;
                default:
                    return null;
            }
        }
}
