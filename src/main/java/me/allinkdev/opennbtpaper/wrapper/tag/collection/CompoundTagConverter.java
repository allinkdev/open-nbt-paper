package me.allinkdev.opennbtpaper.wrapper.tag.collection;


import com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.GenericConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;
import net.minecraft.nbt.Tag;

public class CompoundTagConverter extends NoConstructor {

	public static CompoundTag convert(final net.minecraft.nbt.CompoundTag original,
		@Nullable String name) {
		final CompoundTag converted = new CompoundTag(name == null ? "" : name);

		for (Entry<String, Tag> tagEntry : original.tags.entrySet()) {
			final String key = tagEntry.getKey();
			final Tag tag = tagEntry.getValue();

			final com.github.steveice10.opennbt.tag.builtin.Tag genericConvert = GenericConverter.genericConvert(
				tag, key);

			converted.put(genericConvert);
		}

		return converted;
	}

	public static net.minecraft.nbt.CompoundTag reverse(final CompoundTag original) {
		final net.minecraft.nbt.CompoundTag converted = new net.minecraft.nbt.CompoundTag();

		for (String key : original.keySet()) {
			final com.github.steveice10.opennbt.tag.builtin.Tag value = original.get(key);
			final Tag genericReverse = GenericConverter.genericReverse(value);

			converted.put(key, genericReverse);
		}

		return converted;
	}
}
