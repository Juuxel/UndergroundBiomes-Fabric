import ub_enums
import os


def generate_gravel_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/gravel.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_gravel_" + variant
            final_file = data.replace("minecraft:gravel", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_sand_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_sand_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_cobble_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_cobble_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_brick_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_brick_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_cobble_stairs_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_cobble_stairs_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_stone_stairs_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_stone_stairs_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_stone_button_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_stone_button_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

def generate_cobble_button_loot():
    folder = "build/resources/main/data/undergroundbiomes/loot_tables/blocks/"

    data = 0
    with open('resources_templates/loot_tables/basic.json', 'r') as file:
        data = file.read()

    if not os.path.exists(folder):
        os.makedirs(folder)

    for stype in ub_enums.ubc_types_and_variants:
        for variant in ub_enums.ubc_types_and_variants[stype]:
            block_name = stype + "_cobble_button_" + variant
            final_file = data.replace("blocktodrop", "undergroundbiomes:" + block_name)
            print(block_name)
            text_file = open(folder + block_name + ".json", "w")
            text_file.write(final_file)
            text_file.close()

