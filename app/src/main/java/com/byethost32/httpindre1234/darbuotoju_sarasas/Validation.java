package com.byethost32.httpindre1234.darbuotoju_sarasas;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by moksleivis on 2018-01-10.
 */

public class Validation {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^[0-9a-zA-Z]{3,15}$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher (credentials);
        return matcher.matches();
    }

}