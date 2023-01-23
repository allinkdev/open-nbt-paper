package me.allinkdev.opennbtpaper.wrapper.tag.classes;

import com.github.steveice10.opennbt.tag.builtin.StringTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class StringTagConverter extends NoConstructor {

	public static StringTag convert(final net.minecraft.nbt.StringTag original,
		@Nullable String name) {
		final String value = original.getAsString();

		return new StringTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.StringTag reverse(final StringTag original) {
		final String value = original.getValue();

		return net.minecraft.nbt.StringTag.valueOf(value);
	}
}
