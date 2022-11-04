package net.alexatorv13.testmod.block;

import net.alexatorv13.testmod.Testmod;
import net.alexatorv13.testmod.item.ModCreativeModeTab;
import net.alexatorv13.testmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, Testmod.MOD_ID);

    public static final RegistryObject<Block> SAPHIRON_BLOCK = registerBlock("saphiron_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()),ModCreativeModeTab.TESTMOD_TAB);
    public static final RegistryObject<Block> SAPHIRON_ORE = registerBlock("saphiron_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TESTMOD_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,CreativeModeTab tab){

        RegistryObject<T> toReturn= BLOCKS.register(name,block);
        registerBlockItem(name,toReturn,tab);
        return  toReturn;
    }

private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

    return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties().tab(tab)));
}
    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }
}
