package me.allinkdev.opennbtpaper.wrapper.tag.collection;

import com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.github.steveice10.opennbt.tag.builtin.Tag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.GenericConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class ListTagConverter extends NoConstructor {

	public static ListTag convert(final net.minecraft.nbt.ListTag original, @Nullable String name) {
		final ListTag converted = new ListTag(name == null ? "" : name);

		for (final net.minecraft.nbt.Tag value : original) {
			final Tag object = GenericConverter.genericConvert(value, "");

			converted.add(object);
		}

		return converted;
	}

	public static net.minecraft.nbt.ListTag reverse(final ListTag original) {
		final net.minecraft.nbt.ListTag reversed = new net.minecraft.nbt.ListTag();

		for (final Tag value : original) {
			final net.minecraft.nbt.Tag object = GenericConverter.genericReverse(value);

			reversed.add(object);
		}

		return reversed;
	}
}
