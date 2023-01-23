package me.allinkdev.opennbtpaper.wrapper.tag.primitive;

import com.github.steveice10.opennbt.tag.builtin.DoubleTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class DoubleTagConverter extends NoConstructor {

	public static DoubleTag convert(final net.minecraft.nbt.DoubleTag original,
		@Nullable String name) {
		final double value = original.getAsDouble();

		return new DoubleTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.DoubleTag reverse(final DoubleTag original) {
		final double value = original.getValue();

		return net.minecraft.nbt.DoubleTag.valueOf(value);
	}
}
