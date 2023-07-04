package com.foofinc.mods.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class UtilityFunctions {
    public Function<String, String> urlDecoder = s -> URLDecoder.decode(s, StandardCharsets.UTF_8);
}
