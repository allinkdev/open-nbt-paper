package me.allinkdev.opennbtpaper.wrapper.tag.collection;

import com.github.steveice10.opennbt.tag.builtin.IntArrayTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class IntArrayTagConverter extends NoConstructor {

	public static IntArrayTag convert(final net.minecraft.nbt.IntArrayTag original,
		@Nullable String name) {
		final int[] value = original.getAsIntArray();

		return new IntArrayTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.IntArrayTag reverse(final IntArrayTag original) {
		final int[] value = original.getValue();

		return new net.minecraft.nbt.IntArrayTag(value);
	}
}
