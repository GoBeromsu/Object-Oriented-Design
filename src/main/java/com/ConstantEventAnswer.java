package com;

public class ConstantEventAnswer{

    Answer hospital1;
    Answer hospital2;
    Answer mospital1;
    Answer mospital2;

    ConstantEventAnswer()
    {
        hospital1.message="1. 치료한다";
        hospital1.tag="hospital1";

        hospital2.message="2. 치료하지 않는다";
        hospital2.tag="hospital2";

        mospital1.message="1. 치료한다";
        mospital1.tag="mospital1";

        mospital2.message="2. 치료하지 않는다";
        mospital2.tag="mospital2";
    }
}