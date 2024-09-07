package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Board {
    private Tail[] tails;

    public Tail getTail(Coordinate coordinate){
        for(Tail tail:tails){
            if(tail.getCoordinates().getX_coordinate()==coordinate.getX_coordinate()&&
               tail.getCoordinates().getY_coordinate()==coordinate.getY_coordinate()){
                return tail;
            }
        }
        return null;
    }
}

