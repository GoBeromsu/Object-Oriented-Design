package com;

import lombok.*;

@Getter
@Setter
public class Answer{
    private String message;
    private String tag;
    private ItemType item=null;

    Answer(String message, String tag)
    {
        this.message=message;
        this.tag=tag;
    }

    Answer(ItemType item, String message, String tag)
    {
        this.message=message;
        this.item=item;
        this.tag=tag;
    }
}