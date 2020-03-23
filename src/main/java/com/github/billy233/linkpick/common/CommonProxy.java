package com.github.billy233.linkpick.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    
    public void preLoad(FMLPreInitializationEvent event) {

    }

    public void load(FMLInitializationEvent event) {
        new EventLoader(event);
    }

    public void postLoad(FMLPostInitializationEvent event) {
        
    }
}
