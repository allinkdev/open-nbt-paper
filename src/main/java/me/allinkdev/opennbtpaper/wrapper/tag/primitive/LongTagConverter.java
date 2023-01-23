package me.allinkdev.opennbtpaper.wrapper.tag.primitive;

import com.github.steveice10.opennbt.tag.builtin.LongTag;
import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.NoConstructor;

public class LongTagConverter extends NoConstructor {

	public static LongTag convert(final net.minecraft.nbt.LongTag original, @Nullable String name) {
		final long value = original.getAsLong();

		return new LongTag(name == null ? "" : name, value);
	}

	public static net.minecraft.nbt.LongTag reverse(final LongTag original) {
		final long value = original.getValue();

		return net.minecraft.nbt.LongTag.valueOf(value);
	}
}
