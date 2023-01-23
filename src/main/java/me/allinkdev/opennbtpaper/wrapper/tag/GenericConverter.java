package me.allinkdev.opennbtpaper.wrapper.tag;

import javax.annotation.Nullable;
import me.allinkdev.opennbtpaper.wrapper.tag.classes.StringTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.ByteArrayTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.CompoundTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.IntArrayTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.ListTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.collection.LongArrayTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.primitive.ByteTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.primitive.DoubleTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.primitive.FloatTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.primitive.IntTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.primitive.LongTagConverter;
import me.allinkdev.opennbtpaper.wrapper.tag.primitive.ShortTagConverter;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.ByteTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.nbt.FloatTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.LongArrayTag;
import net.minecraft.nbt.LongTag;
import net.minecraft.nbt.ShortTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagType;
import org.apache.commons.lang.NotImplementedException;

public class GenericConverter extends NoConstructor {

	public static <T extends Tag> com.github.steveice10.opennbt.tag.builtin.Tag genericConvert(
		final T tag, @Nullable String name) {
		final TagType<?> type = tag.getType();

		// Primitives
		if (type == ByteTag.TYPE) {
			return ByteTagConverter.convert((ByteTag) tag, name);
		}

		if (type == DoubleTag.TYPE) {
			return DoubleTagConverter.convert((DoubleTag) tag, name);
		}

		if (type == FloatTag.TYPE) {
			return FloatTagConverter.convert((FloatTag) tag, name);
		}

		if (type == IntTag.TYPE) {
			return IntTagConverter.convert((IntTag) tag, name);
		}

		if (type == LongTag.TYPE) {
			return LongTagConverter.convert((LongTag) tag, name);
		}

		if (type == ShortTag.TYPE) {
			return ShortTagConverter.convert((ShortTag) tag, name);
		}

		if (type == StringTag.TYPE) {
			return StringTagConverter.convert((StringTag) tag, name);
		}

		// Collections
		if (type == ByteArrayTag.TYPE) {
			return ByteArrayTagConverter.convert((ByteArrayTag) tag, name);
		}

		if (type == IntArrayTag.TYPE) {
			return IntArrayTagConverter.convert((IntArrayTag) tag, name);
		}

		if (type == LongArrayTag.TYPE) {
			return LongArrayTagConverter.convert((LongArrayTag) tag, name);
		}

		if (type == ListTag.TYPE) {
			return ListTagConverter.convert((ListTag) tag, name);
		}

		if (type == CompoundTag.TYPE) {
			return CompoundTagConverter.convert((CompoundTag) tag, name);
		}

		final Class<? extends Tag> clazz = tag.getClass();
		final String className = clazz.getName();

		throw new NotImplementedException(
			String.format("Converter for NBT tag type %s not implemented yet!", className));
	}

	public static <T extends com.github.steveice10.opennbt.tag.builtin.Tag> Tag genericReverse(
		final T tag) {
		final Class<? extends com.github.steveice10.opennbt.tag.builtin.Tag> clazz = tag.getClass();

		// Primitives
		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.ByteTag.class)) {
			return ByteTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.ByteTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.DoubleTag.class)) {
			return DoubleTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.DoubleTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.FloatTag.class)) {
			return FloatTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.FloatTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.IntTag.class)) {
			return IntTagConverter.reverse((com.github.steveice10.opennbt.tag.builtin.IntTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.LongTag.class)) {
			return LongTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.LongTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.ShortTag.class)) {
			return ShortTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.ShortTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.StringTag.class)) {
			return StringTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.StringTag) tag);
		}

		// Collections
		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.ByteArrayTag.class)) {
			return ByteArrayTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.ByteArrayTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.IntArrayTag.class)) {
			return IntArrayTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.IntArrayTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.LongArrayTag.class)) {
			return LongArrayTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.LongArrayTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.ListTag.class)) {
			return ListTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.ListTag) tag);
		}

		if (clazz.equals(com.github.steveice10.opennbt.tag.builtin.CompoundTag.class)) {
			return CompoundTagConverter.reverse(
				(com.github.steveice10.opennbt.tag.builtin.CompoundTag) tag);
		}

		final String className = clazz.getName();

		throw new NotImplementedException(
			String.format("Reverser for NBT tag type %s not implemented yet!", className));
	}
}
