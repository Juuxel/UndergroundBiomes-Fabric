import ub_enums
import os


def generate_smelting_cobble_recipes():
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


def generate_stone_brick_recipes():
    folder = "build/resources/main/data/undergroundbiomes/recipes/"

    data = 0
    with open('resources_templates/recipes/stone_brick.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name_brick = stype + "_brick_" + variant
            block_name_stone = stype + "_stone_" + variant
            final_file = data.replace("itemin", "undergroundbiomes:" + block_name_stone).replace("itemout", "undergroundbiomes:" + block_name_brick)
            print(block_name_stone)
            text_file = open(folder + block_name_brick + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_stone_stair_recipes():
    folder = "build/resources/main/data/undergroundbiomes/recipes/"

    data = 0
    with open('resources_templates/recipes/stairs.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name_stairs = stype + "_stone_stairs_" + variant
            block_name_stone = stype + "_stone_" + variant
            final_file = data.replace("itemin", "undergroundbiomes:" + block_name_stone).replace("itemout", "undergroundbiomes:" + block_name_stairs)
            print(block_name_stone)
            text_file = open(folder + block_name_stairs + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_cobble_stair_recipes():
    folder = "build/resources/main/data/undergroundbiomes/recipes/"

    data = 0
    with open('resources_templates/recipes/stairs.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            if variant != 'lignite':
                block_name_stairs = stype + "_cobble_stairs_" + variant
                block_name_stone = stype + "_cobble_" + variant
                final_file = data.replace("itemin", "undergroundbiomes:" + block_name_stone).replace("itemout", "undergroundbiomes:" + block_name_stairs)
                print(block_name_stone)
                text_file = open(folder + block_name_stairs + ".json", "w")
                text_file.write(final_file)
                text_file.close()

def generate_stone_button_recipes():
    folder = "build/resources/main/data/undergroundbiomes/recipes/"

    data = 0
    with open('resources_templates/recipes/button.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name_button = stype + "_stone_button_" + variant
            block_name_stone = stype + "_stone_" + variant
            final_file = data.replace("itemin", "undergroundbiomes:" + block_name_stone).replace("itemout", "undergroundbiomes:" + block_name_button)
            print(block_name_button)
            text_file = open(folder + block_name_button + ".json", "w")
            text_file.write(final_file)
            text_file.close()