package com.github.billy233.linkpick;

import com.github.billy233.linkpick.common.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LinkPick.MODID, name = LinkPick.NAME, version = LinkPick.VERSION, acceptedMinecraftVersions = "1.7.10")
public class LinkPick {
    
    public static final String MODID = "linkpick";
    public static final String NAME = "Link Pick";
    public static final String VERSION = "0.1.0.200323_beta";

    @Instance(LinkPick.MODID)
    public static LinkPick instance;

    @SidedProxy(modId = "linkpick",clientSide="com.github.billy233.linkpick.client.ClientProxy",
            serverSide="com.github.billy233.linkpick.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preLoad(FMLPreInitializationEvent event) {
        proxy.preLoad(event);
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.load(event);
    }

    @EventHandler
    public void postLoad(FMLPostInitializationEvent event) {
        proxy.postLoad(event);
    }
}
