package com.github.billy233.linkpick.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class EventLoader {
    
    public EventLoader(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreHarvest(HarvestDropsEvent event) {
        if (!event.world.isRemote && event.harvester != null) {

            if (event.harvester.getHeldItem().getItem() instanceof ItemPickaxe && event.block instanceof BlockOre) {
                
                Block block = event.block;
                World world = event.world;
                int cnt = 0;

                int xMin = event.x - 8;
                int xMax = event.x + 8;
                int yMin = event.y - 8;
                int yMax = event.y + 8;
                int zMin = event.z - 8;
                int zMax = event.z + 8;
                for (int i = xMin; i <= xMax; i++) {
                    for (int j = yMin; j <= yMax; j++) {
                        for (int k = zMin; k <= zMax; k++) {
                            if (world.getBlock(i, j, k) == block) {
                                cnt++;
                                world.setBlockToAir(i, j, k);
                            }
                        }
                    }
                }

                
                if (cnt > 0) {
                    world.spawnEntityInWorld(new EntityItem(world, event.x, event.y, event.z, new ItemStack(block, cnt)));
                }

            }
        }

    }
}
