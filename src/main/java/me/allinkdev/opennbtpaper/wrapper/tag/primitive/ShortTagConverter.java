package me.allinkdev.opennbtpaper.wrapper.tag.primitive;

import com.github.steveice10.opennbt.tag.builtin.ShortTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class ShortTagConverter extends NoConstructor {

	public static ShortTag convert(final net.minecraft.nbt.ShortTag original,
		@Nullable String name) {
		final short value = original.getAsShort();

		return new ShortTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.ShortTag reverse(final ShortTag original) {
		final short value = original.getValue();

		return net.minecraft.nbt.ShortTag.valueOf(value);
	}
}
