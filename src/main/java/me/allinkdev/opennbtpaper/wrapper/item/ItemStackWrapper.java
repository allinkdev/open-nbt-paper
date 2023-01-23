package me.allinkdev.opennbtpaper.wrapper.item;

import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.github.steveice10.opennbt.tag.builtin.StringTag;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.CompoundTagConverter;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_19_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class ItemStackWrapper extends NoConstructor {

	public static CompoundTag getNbt(final ItemStack itemStack) {
		final net.minecraft.world.item.ItemStack vanillaItemStack = CraftItemStack.asNMSCopy(
			itemStack);
		final CompoundTag itemTag = new CompoundTag("");
		final net.minecraft.nbt.CompoundTag tag = vanillaItemStack.getOrCreateTag();
		final CompoundTag nbtTag = CompoundTagConverter.convert(tag, "tag");
		final ByteTag count = new ByteTag("Count", (byte) itemStack.getAmount());
		itemTag.put(count);

		if (!nbtTag.isEmpty()) {
			itemTag.put(nbtTag);
		}

		final Material itemMaterial = itemStack.getType();
		final String itemName = itemMaterial.key().asString();
		final StringTag idTag = new StringTag("id", itemName);
		itemTag.put(idTag);

		return itemTag;
	}

	public static ItemStack withNbt(final ItemStack itemStack, final CompoundTag tag) {
		final net.minecraft.world.item.ItemStack vanillaStack = CraftItemStack.asNMSCopy(itemStack);
		final net.minecraft.nbt.CompoundTag vanillaTag = CompoundTagConverter.reverse(tag);

		if (vanillaTag.contains("tag")) {
			final net.minecraft.nbt.CompoundTag actualTag = vanillaTag.getCompound("tag");
			vanillaStack.setTag(actualTag);
		} else {
			vanillaStack.setTag(vanillaTag);
		}

		return vanillaStack.getBukkitStack();
	}

	public static ItemStack fromNbt(final CompoundTag tag) {
		final net.minecraft.nbt.CompoundTag vanillaTag = CompoundTagConverter.reverse(tag);
		final net.minecraft.world.item.ItemStack vanillaStack = net.minecraft.world.item.ItemStack.of(
			vanillaTag);

		return vanillaStack.getBukkitStack();
	}
}
