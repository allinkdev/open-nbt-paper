package me.allinkdev.opennbtpaper.wrapper.tag.primitive;

import com.github.steveice10.opennbt.tag.builtin.ByteTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class ByteTagConverter extends NoConstructor {

	public static ByteTag convert(final net.minecraft.nbt.ByteTag original, @Nullable String name) {
		final byte value = original.getAsByte();

		return new ByteTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.ByteTag reverse(final ByteTag original) {
		final byte value = original.getValue();

		return net.minecraft.nbt.ByteTag.valueOf(value);
	}
}
