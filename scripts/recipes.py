import ub_enums
import os


def generate_smelting_cobble():
    folder = "build/resources/main/data/undergroundbiomes/recipes/"

    data = 0
    with open('resources_templates/recipes/smelting_cobble.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name_cobble = stype + "_cobble_" + variant
                block_name_stone = stype + "_stone_" + variant
                final_file = data.replace("itemin", "undergroundbiomes:" + block_name_cobble).replace("itemout", "undergroundbiomes:" + block_name_stone)
                print(block_name_stone)
                text_file = open(folder + block_name_stone + ".json", "w")
                text_file.write(final_file)
                text_file.close()