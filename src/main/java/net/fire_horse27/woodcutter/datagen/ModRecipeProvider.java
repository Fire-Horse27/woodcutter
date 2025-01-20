package net.fire_horse27.woodcutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final int WOODCOUNT = 12;

    private static final List<TagKey<Item>> Log = List.of(ItemTags.OAK_LOGS, ItemTags.SPRUCE_LOGS, ItemTags.BIRCH_LOGS,
            ItemTags.JUNGLE_LOGS, ItemTags.ACACIA_LOGS, ItemTags.DARK_OAK_LOGS, ItemTags.MANGROVE_LOGS,
            ItemTags.CHERRY_LOGS, ItemTags.BAMBOO_BLOCKS, ItemTags.CRIMSON_STEMS, ItemTags.WARPED_STEMS,
            ItemTags.PALE_OAK_LOGS);

    private static final List<Item> Plank = List.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
            Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, Items.PALE_OAK_PLANKS, Items.BAMBOO_MOSAIC);

    private static final List<Item> Slab = List.of(Items.OAK_SLAB, Items.SPRUCE_SLAB, Items.BIRCH_SLAB,
            Items.JUNGLE_SLAB, Items.ACACIA_SLAB, Items.DARK_OAK_SLAB, Items.MANGROVE_SLAB, Items.CHERRY_SLAB,
            Items.BAMBOO_SLAB, Items.CRIMSON_SLAB, Items.WARPED_SLAB, Items.PALE_OAK_SLAB, Items.BAMBOO_MOSAIC_SLAB);

    private static final List<Item> Stair = List.of(Items.OAK_STAIRS, Items.SPRUCE_STAIRS, Items.BIRCH_STAIRS,
            Items.JUNGLE_STAIRS, Items.ACACIA_STAIRS, Items.DARK_OAK_STAIRS, Items.MANGROVE_STAIRS,
            Items.CHERRY_STAIRS, Items.BAMBOO_STAIRS, Items.CRIMSON_STAIRS, Items.WARPED_STAIRS,
            Items.PALE_OAK_STAIRS, Items.BAMBOO_MOSAIC_STAIRS);

    private static final List<Item> Button = List.of(Items.OAK_BUTTON, Items.SPRUCE_BUTTON, Items.BIRCH_BUTTON,
            Items.JUNGLE_BUTTON, Items.ACACIA_BUTTON, Items.DARK_OAK_BUTTON, Items.MANGROVE_BUTTON,
            Items.CHERRY_BUTTON, Items.BAMBOO_BUTTON, Items.CRIMSON_BUTTON, Items.WARPED_BUTTON, Items.PALE_OAK_BUTTON);

    private static final List<Item> PressurePlate = List.of(Items.OAK_PRESSURE_PLATE, Items.SPRUCE_PRESSURE_PLATE,
            Items.BIRCH_PRESSURE_PLATE, Items.JUNGLE_PRESSURE_PLATE, Items.ACACIA_PRESSURE_PLATE,
            Items.DARK_OAK_PRESSURE_PLATE, Items.MANGROVE_PRESSURE_PLATE, Items.CHERRY_PRESSURE_PLATE,
            Items.BAMBOO_PRESSURE_PLATE, Items.CRIMSON_PRESSURE_PLATE, Items.WARPED_PRESSURE_PLATE,
            Items.PALE_OAK_PRESSURE_PLATE);

    private static final List<Item> Trapdoor = List.of(Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.BIRCH_TRAPDOOR,
            Items.JUNGLE_TRAPDOOR, Items.ACACIA_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.MANGROVE_TRAPDOOR,
            Items.CHERRY_TRAPDOOR, Items.BAMBOO_TRAPDOOR, Items.CRIMSON_TRAPDOOR, Items.WARPED_TRAPDOOR,
            Items.PALE_OAK_TRAPDOOR);

    private static final List<Item> CopperBlock = List.of(Items.COPPER_BLOCK, Items.EXPOSED_COPPER,
            Items.WEATHERED_COPPER, Items.OXIDIZED_COPPER, Items.WAXED_COPPER_BLOCK, Items.WAXED_EXPOSED_COPPER,
            Items.WAXED_WEATHERED_COPPER, Items.WAXED_OXIDIZED_COPPER);

    private static final List<Item> CopperTrapdoor = List.of(Items.COPPER_TRAPDOOR, Items.EXPOSED_COPPER_TRAPDOOR,
            Items.WEATHERED_COPPER_TRAPDOOR, Items.OXIDIZED_COPPER_TRAPDOOR, Items.WAXED_COPPER_TRAPDOOR,
            Items.WAXED_EXPOSED_COPPER_TRAPDOOR, Items.WAXED_WEATHERED_COPPER_TRAPDOOR,
            Items.WAXED_OXIDIZED_COPPER_TRAPDOOR);

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                for (int i = 0; i < WOODCOUNT; i++) {
                    var tag = registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(Log.get(i));
                    StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.fromTag(tag),
                            RecipeCategory.MISC, Plank.get(i), 4)
                            .criterion("has_" + Log.get(i).id().getPath(), this.conditionsFromTag(Log.get(i)))
                            .offerTo(exporter, "woodcutter:" + getItemPath(Plank.get(i)) + "_from_" +
                                    Log.get(i).id().getPath() + "_stonecutting");
                }

                for (int i = 0; i < WOODCOUNT + 1; i++) {
                    offerStonecuttingRecipe(RecipeCategory.MISC, Slab.get(i), Plank.get(i), 2);
                    offerStonecuttingRecipe(RecipeCategory.MISC, Stair.get(i), Plank.get(i));
                }

                for (int i = 0; i < WOODCOUNT; i++) {
                    offerStonecuttingRecipe(RecipeCategory.MISC, Button.get(i), Plank.get(i), 4);
                    offerStonecuttingRecipe(RecipeCategory.MISC, PressurePlate.get(i), Plank.get(i), 2);
                    offerStonecuttingRecipe(RecipeCategory.MISC, Trapdoor.get(i), Plank.get(i), 2);
                }

                offerStonecuttingRecipe(RecipeCategory.MISC, Items.COBBLED_DEEPSLATE, Items.DEEPSLATE);

                for (int i = 0; i < 8; i++) {
                    offerStonecuttingRecipe(RecipeCategory.MISC, CopperTrapdoor.get(i), CopperBlock.get(i), 3);
                }
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
