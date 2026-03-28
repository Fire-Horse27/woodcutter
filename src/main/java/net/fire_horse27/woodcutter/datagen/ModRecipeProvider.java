package net.fire_horse27.woodcutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
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

    private static final List<Item> Materials = List.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS,
            Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CHERRY_PLANKS,
            Items.BAMBOO_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, Items.PALE_OAK_PLANKS, Items.BAMBOO_MOSAIC,
            Items.STONE, Items.BLACKSTONE, Items.POLISHED_BLACKSTONE);

    private static final List<Item> Slab = List.of(Items.OAK_SLAB, Items.SPRUCE_SLAB, Items.BIRCH_SLAB,
            Items.JUNGLE_SLAB, Items.ACACIA_SLAB, Items.DARK_OAK_SLAB, Items.MANGROVE_SLAB, Items.CHERRY_SLAB,
            Items.BAMBOO_SLAB, Items.CRIMSON_SLAB, Items.WARPED_SLAB, Items.PALE_OAK_SLAB, Items.BAMBOO_MOSAIC_SLAB);

    private static final List<Item> Stair = List.of(Items.OAK_STAIRS, Items.SPRUCE_STAIRS, Items.BIRCH_STAIRS,
            Items.JUNGLE_STAIRS, Items.ACACIA_STAIRS, Items.DARK_OAK_STAIRS, Items.MANGROVE_STAIRS,
            Items.CHERRY_STAIRS, Items.BAMBOO_STAIRS, Items.CRIMSON_STAIRS, Items.WARPED_STAIRS,
            Items.PALE_OAK_STAIRS, Items.BAMBOO_MOSAIC_STAIRS);

    private static final List<Item> Button = List.of(Items.OAK_BUTTON, Items.SPRUCE_BUTTON, Items.BIRCH_BUTTON,
            Items.JUNGLE_BUTTON, Items.ACACIA_BUTTON, Items.DARK_OAK_BUTTON, Items.MANGROVE_BUTTON,
            Items.CHERRY_BUTTON, Items.BAMBOO_BUTTON, Items.CRIMSON_BUTTON, Items.WARPED_BUTTON, Items.PALE_OAK_BUTTON,
            Items.STONE_BUTTON, Items.POLISHED_BLACKSTONE_BUTTON, Items.POLISHED_BLACKSTONE_BUTTON);

    private static final List<Item> PressurePlate = List.of(Items.OAK_PRESSURE_PLATE, Items.SPRUCE_PRESSURE_PLATE,
            Items.BIRCH_PRESSURE_PLATE, Items.JUNGLE_PRESSURE_PLATE, Items.ACACIA_PRESSURE_PLATE,
            Items.DARK_OAK_PRESSURE_PLATE, Items.MANGROVE_PRESSURE_PLATE, Items.CHERRY_PRESSURE_PLATE,
            Items.BAMBOO_PRESSURE_PLATE, Items.CRIMSON_PRESSURE_PLATE, Items.WARPED_PRESSURE_PLATE,
            Items.PALE_OAK_PRESSURE_PLATE, Items.STONE_PRESSURE_PLATE, Items.POLISHED_BLACKSTONE_PRESSURE_PLATE,
            Items.POLISHED_BLACKSTONE_PRESSURE_PLATE);

    private static final List<Item> Trapdoor = List.of(Items.OAK_TRAPDOOR, Items.SPRUCE_TRAPDOOR, Items.BIRCH_TRAPDOOR,
            Items.JUNGLE_TRAPDOOR, Items.ACACIA_TRAPDOOR, Items.DARK_OAK_TRAPDOOR, Items.MANGROVE_TRAPDOOR,
            Items.CHERRY_TRAPDOOR, Items.BAMBOO_TRAPDOOR, Items.CRIMSON_TRAPDOOR, Items.WARPED_TRAPDOOR,
            Items.PALE_OAK_TRAPDOOR);

    private static final List<Item> MetalBlock = List.of(Items.COPPER_BLOCK, Items.EXPOSED_COPPER,
            Items.WEATHERED_COPPER, Items.OXIDIZED_COPPER, Items.WAXED_COPPER_BLOCK, Items.WAXED_EXPOSED_COPPER,
            Items.WAXED_WEATHERED_COPPER, Items.WAXED_OXIDIZED_COPPER, Items.IRON_BLOCK);

    private static final List<Item> MetalTrapdoor = List.of(Items.COPPER_TRAPDOOR, Items.EXPOSED_COPPER_TRAPDOOR,
            Items.WEATHERED_COPPER_TRAPDOOR, Items.OXIDIZED_COPPER_TRAPDOOR, Items.WAXED_COPPER_TRAPDOOR,
            Items.WAXED_EXPOSED_COPPER_TRAPDOOR, Items.WAXED_WEATHERED_COPPER_TRAPDOOR,
            Items.WAXED_OXIDIZED_COPPER_TRAPDOOR, Items.IRON_TRAPDOOR);

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {
                for (int i = 0; i < WOODCOUNT; i++) {
                    if (i == 8) {
                        stonecuttingRecipeFromTag(Log.get(i), Materials.get(i), 2);
                    }
                    else {
                        stonecuttingRecipeFromTag(Log.get(i), Materials.get(i), 4);
                    }
                }

                for (int i = 0; i < WOODCOUNT + 1; i++) {
                    stonecuttingRecipe(Materials.get(i), Slab.get(i), 2);
                    stonecuttingRecipe(Materials.get(i), Stair.get(i), 1);
                }

                for (int i = 0; i < WOODCOUNT; i++) {
                    stonecuttingRecipe(Materials.get(i), Button.get(i), 4);
                    stonecuttingRecipe(Materials.get(i), PressurePlate.get(i), 2);
                    stonecuttingRecipe(Materials.get(i), Trapdoor.get(i), 2);
                }

                for (int i = WOODCOUNT; i < WOODCOUNT + 3; i++) {
                    stonecuttingRecipe(Materials.get(i + 1), Button.get(i), 4);
                    stonecuttingRecipe(Materials.get(i + 1), PressurePlate.get(i), 2);
                }

//                stonecuttingRecipe(Items.DEEPSLATE, Items.COBBLED_DEEPSLATE, 1);
//                stonecuttingRecipe(Items.STONE, Items.COBBLESTONE, 1);

                for (int i = 0; i < 9; i++) {
                    stonecuttingRecipe(MetalBlock.get(i), MetalTrapdoor.get(i), 3);
                }
            }

            private void stonecuttingRecipe(ItemConvertible input, ItemConvertible output, int count) {
                StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItem(input), RecipeCategory.MISC,
                                output, count)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, "woodcutter:" + convertBetween(output, input) + "_stonecutting");
            }

            private void stonecuttingRecipeFromTag(TagKey<Item> input, ItemConvertible output, int count) {
                var tag = registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(input);
                StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.fromTag(tag),
                                RecipeCategory.MISC, output, count)
                        .criterion("has_" + input.id().getPath(), this.conditionsFromTag(input))
                        .offerTo(exporter, "woodcutter:" + getItemPath(output) + "_from_" +
                                input.id().getPath() + "_stonecutting");
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
