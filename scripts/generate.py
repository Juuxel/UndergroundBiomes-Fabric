import loot_tables
import recipes

# Loot tables
loot_tables.generate_gravel_loot()
loot_tables.generate_sand_loot()
loot_tables.generate_cobble_loot()
loot_tables.generate_brick_loot()
loot_tables.generate_cobble_stairs_loot()
loot_tables.generate_stone_stairs_loot()
loot_tables.generate_stone_button_loot()
loot_tables.generate_cobble_button_loot()

# Recipes
recipes.generate_smelting_cobble_recipes()
recipes.generate_stone_brick_recipes()