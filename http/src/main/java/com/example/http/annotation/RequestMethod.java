package com.example.http.annotation;

import androidx.annotation.IntDef;

import static com.example.http.annotation.RequestMethod.Get;
import static com.example.http.annotation.RequestMethod.Post;

/*
 * @Author: Luke
 * @Date: 2/18/21 4:53 PM
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Luke_app
 */
@IntDef({Get,Post})
public @interface RequestMethod {
    int Get =1;
    int Post =2;
}
