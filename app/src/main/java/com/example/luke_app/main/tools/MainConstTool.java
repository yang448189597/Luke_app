package com.example.luke_app.main.tools;

import androidx.annotation.IntDef;

import static com.example.luke_app.main.tools.MainConstTool.BEIJING;
import static com.example.luke_app.main.tools.MainConstTool.HANGZHOU;
import static com.example.luke_app.main.tools.MainConstTool.SHANGHAI;
import static com.example.luke_app.main.tools.MainConstTool.SHENZHEN;

/*
 * @Author: Luke
 * @Date: 12/28/20 3:36 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainConstTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
