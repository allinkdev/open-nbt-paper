package me.allinkdev.opennbtpaper.wrapper.tag.collection;

import com.github.steveice10.opennbt.tag.builtin.ByteArrayTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class ByteArrayTagConverter extends NoConstructor {

	public static ByteArrayTag convert(final net.minecraft.nbt.ByteArrayTag original,
		@Nullable String name) {
		final byte[] byteArray = original.getAsByteArray();

		return new ByteArrayTag(name == null ? "" : name, byteArray);
	}

	public static net.minecraft.nbt.ByteArrayTag reverse(final ByteArrayTag original) {
		final byte[] byteArray = original.getValue();

		return new net.minecraft.nbt.ByteArrayTag(byteArray);
	}
}
