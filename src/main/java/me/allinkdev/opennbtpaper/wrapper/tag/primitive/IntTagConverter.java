package me.allinkdev.opennbtpaper.wrapper.tag.primitive;

import com.github.steveice10.opennbt.tag.builtin.IntTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class IntTagConverter extends NoConstructor {

	public static IntTag convert(final net.minecraft.nbt.IntTag original, @Nullable String name) {
		final int value = original.getAsInt();

		return new IntTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.IntTag reverse(final IntTag original) {
		final int value = original.getValue();

		return net.minecraft.nbt.IntTag.valueOf(value);
	}
}
