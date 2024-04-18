package net.micaxs.mechanicalbotania.data;

import net.micaxs.mechanicalbotania.MechanicalBotania;
import net.micaxs.mechanicalbotania.init.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import vazkii.botania.common.lib.BotaniaTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {

    public ItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MechanicalBotania.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BotaniaTags.Items.CONTRIBUTOR_HEADFLOWERS).add(ItemRegistry.SPINERETTE_ITEM.get());
        this.tag(BotaniaTags.Items.SPECIAL_FLOWERS).add(ItemRegistry.SPINERETTE_ITEM.get());;
        this.tag(BotaniaTags.Items.SPECIAL_FLOATING_FLOWERS).add(ItemRegistry.SPINERETTE_FLOATING_ITEM.get());
    }
}
