package me.allinkdev.opennbtpaper.wrapper.tag.primitive;

import com.github.steveice10.opennbt.tag.builtin.FloatTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class FloatTagConverter extends NoConstructor {

	public static FloatTag convert(final net.minecraft.nbt.FloatTag original,
		@Nullable String name) {
		final float value = original.getAsFloat();

		return new FloatTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.FloatTag reverse(final FloatTag original) {
		final float value = original.getValue();

		return net.minecraft.nbt.FloatTag.valueOf(value);
	}
}
