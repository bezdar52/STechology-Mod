package com.bbexx.stm;

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

@Mod(modid = StmMod.MODID, version = Tags.VERSION, name = "stm", acceptedMinecraftVersions = "[1.7.10]", dependencies = "after:appliedenergistics2;")
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
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new com.bbexx.stm.GUI.GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("[STM] Начался этап PostInit. Ищем Applied Energistics 2...");

        // Используем самый надежный способ получения предмета напрямую из общего реестра Minecraft
        net.minecraft.item.Item ae2Item = (net.minecraft.item.Item) net.minecraft.item.Item.itemRegistry.getObject("appliedenergistics2:tile.BlockEnergyCell");

        // Альтернативная проверка на случай другого ID в вашей сборке AE2
        if (ae2Item == null) {
            ae2Item = (net.minecraft.item.Item) net.minecraft.item.Item.itemRegistry.getObject("appliedenergistics2:BlockEnergyCell");
        }

        if (ae2Item != null) {
            System.out.println("[STM] Отлично! Энергоячейка AE2 успешно найдена. Регистрируем крафт...");
            try {
                // Создаем ItemStack творческой ячейки (Количество: 1, Метадата: 2)
                net.minecraft.item.ItemStack creativeCellStack = new net.minecraft.item.ItemStack(ae2Item, 1, 2);

                // ВАЖНО: Используем ShapedOreRecipe вместо обычного addRecipe
                cpw.mods.fml.common.registry.GameRegistry.addRecipe(
                    new net.minecraftforge.oredict.ShapedOreRecipe(creativeCellStack, new Object[]{
                        "CCC",
                        "RWR",
                        "CCC",
                        'C', "ingotCopper",                           // Теперь строка распознается корректно!
                        'R', net.minecraft.init.Items.redstone,
                        'W', com.bbexx.stm.Item.ModItems.Walkie_Talkie
                    })
                );

                System.out.println("[STM] Крафт для Творческой Энергоячейки AE2 успешно добавлен через OreDict!");
            } catch (Exception e) {
                System.out.println("[STM] Произошла критическая ошибка внутри блока крафта:");
                e.printStackTrace();
            }
        } else {
            System.out.println("[STM] ВНИМАНИЕ: Мод Applied Energistics 2 не найден или его предметы еще не загрузились!");
        }
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
