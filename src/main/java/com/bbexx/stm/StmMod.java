package com.bbexx.stm;

import com.bbexx.stm.Entity.ModEntity;
import com.bbexx.stm.Item.ModItems;
import com.bbexx.stm.creativeTabs.ModTabs;
import cpw.mods.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

// , dependencies = "after:appliedenergistics2;"
@Mod(modid = StmMod.MODID, version = Tags.VERSION, name = "stm", acceptedMinecraftVersions = "[1.7.10]")
public class StmMod {

    public static final String MODID = "stm";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "com.bbexx.stm.ClientProxy", serverSide = "com.bbexx.stm.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance("stm")
    public static StmMod instance;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        // Креативные вкладки
        ModTabs.init();

        // Предметы
        ModItems.init();

        // Entity
        ModEntity.init();
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        proxy.registerRenderers();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new com.bbexx.stm.GUI.GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
