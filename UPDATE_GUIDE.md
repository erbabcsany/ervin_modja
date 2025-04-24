# Minecraft Forge Mod Update Guide: 1.16.5 to 1.20

This guide provides instructions for updating the Ervin Modja mod from Minecraft 1.16.5 through to 1.20. Follow these steps to update your mod to the desired Minecraft version.

## Key Files to Modify

When updating the mod to a different Minecraft version, you need to modify the following files:

1. `gradle.properties` - Contains version information for Minecraft, Forge, and other dependencies
2. `pack.mcmeta` - Contains the pack format version which changes between Minecraft versions
3. Java code files - May require API updates depending on the version changes

## Version-Specific Configuration

### For Minecraft 1.16.5

```properties
# gradle.properties
minecraft_version=1.16.5
minecraft_version_range=[1.16.5,1.17)
forge_version=36.2.39
forge_version_range=[36,)
loader_version_range=[36,)
mapping_version=1.16.5
mod_version=1.0-SNAPSHOT-minecraft_version_1.16.5
```

```json
{
  "pack": {
    "description": "ervin_modja resources",
    "pack_format": 6
  }
}
```

For pack.mcmeta:

Java code changes:
- Use `AbstractBlock.Properties.from(Blocks.COAL_BLOCK)` instead of `AbstractBlock.Properties.copy(Blocks.COAL_BLOCK)`
- Use `ItemGroup.BUILDING_BLOCKS` instead of `ItemGroup.TAB_BUILDING_BLOCKS`

### For Minecraft 1.17.1

```properties
# gradle.properties
minecraft_version=1.17.1
minecraft_version_range=[1.17.1,1.18)
forge_version=37.1.1
forge_version_range=[37,)
loader_version_range=[37,)
mapping_version=1.17.1
mod_version=1.0-SNAPSHOT-minecraft_version_1.17.1
```

```json
{
  "pack": {
    "description": "ervin_modja resources",
    "pack_format": 7
  }
}
```

For pack.mcmeta:

Java code changes:
- Use `AbstractBlock.Properties.copy(Blocks.COAL_BLOCK)`
- Use `ItemGroup.TAB_BUILDING_BLOCKS`

### For Minecraft 1.18.2

```properties
# gradle.properties
minecraft_version=1.18.2
minecraft_version_range=[1.18.2,1.19)
forge_version=40.2.0
forge_version_range=[40,)
loader_version_range=[40,)
mapping_version=1.18.2
mod_version=1.0-SNAPSHOT-minecraft_version_1.18.2
```

```json
{
  "pack": {
    "description": "ervin_modja resources",
    "pack_format": 8
  }
}
```

For pack.mcmeta:

Java code changes:
- Use `AbstractBlock.Properties.copy(Blocks.COAL_BLOCK)`
- Use `ItemGroup.TAB_BUILDING_BLOCKS`

### For Minecraft 1.19.4

```properties
# gradle.properties
minecraft_version=1.19.4
minecraft_version_range=[1.19.4,1.20)
forge_version=45.1.0
forge_version_range=[45,)
loader_version_range=[45,)
mapping_version=1.19.4
mod_version=1.0-SNAPSHOT-minecraft_version_1.19.4
```

```json
{
  "pack": {
    "description": "ervin_modja resources",
    "pack_format": 12
  }
}
```

For pack.mcmeta:

Java code changes:
- Use `AbstractBlock.Properties.copy(Blocks.COAL_BLOCK)`
- Use `CreativeModeTabs.BUILDING_BLOCKS` instead of `ItemGroup.TAB_BUILDING_BLOCKS` (API change in 1.19.3+)

### For Minecraft 1.20.1

```properties
# gradle.properties
minecraft_version=1.20.1
minecraft_version_range=[1.20.1,1.21)
forge_version=47.1.0
forge_version_range=[47,)
loader_version_range=[47,)
mapping_version=1.20.1
mod_version=1.0-SNAPSHOT-minecraft_version_1.20.1
```

```json
{
  "pack": {
    "description": "ervin_modja resources",
    "pack_format": 15
  }
}
```

For pack.mcmeta:

Java code changes:
- Use `AbstractBlock.Properties.copy(Blocks.COAL_BLOCK)`
- Use `CreativeModeTabs.BUILDING_BLOCKS`

## How to Update

1. Backup your mod project before making any changes
2. Update the `gradle.properties` file with the values for your target Minecraft version
3. Update the `pack.mcmeta` file with the correct pack_format value
4. Make any necessary code changes based on API differences
5. Run `./gradlew clean build` to build the mod for the new version
6. Test the mod thoroughly in the new Minecraft version

## Notes

- Always check the Forge documentation for the specific Minecraft version you're targeting
- Some versions may require additional changes not covered in this guide
- The Java toolchain should be set to Java 17 for Minecraft 1.17+ (already configured in build.gradle)
