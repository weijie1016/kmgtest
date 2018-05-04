package com.example.websocket.client;

public final class CeeetyBasePb {
	private CeeetyBasePb() {
	}

	public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {
	}

	public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
		registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
	}

	public interface BaseOrBuilder extends
			// @@protoc_insertion_point(interface_extends:Base)
			com.google.protobuf.MessageOrBuilder {

		/**
		 * <code>string type = 1;</code>
		 */
		java.lang.String getType();

		/**
		 * <code>string type = 1;</code>
		 */
		com.google.protobuf.ByteString getTypeBytes();

		/**
		 * <code>int64 stamp = 2;</code>
		 */
		long getStamp();

		/**
		 * <code>string signature = 3;</code>
		 */
		java.lang.String getSignature();

		/**
		 * <code>string signature = 3;</code>
		 */
		com.google.protobuf.ByteString getSignatureBytes();

		/**
		 * <code>.google.protobuf.Any data = 4;</code>
		 */
		boolean hasData();

		/**
		 * <code>.google.protobuf.Any data = 4;</code>
		 */
		com.google.protobuf.Any getData();

		/**
		 * <code>.google.protobuf.Any data = 4;</code>
		 */
		com.google.protobuf.AnyOrBuilder getDataOrBuilder();
	}

	/**
	 * <pre>
	 * 生成的数据访问类的类名
	 * </pre>
	 *
	 * Protobuf type {@code Base}
	 */
	public static final class Base extends com.google.protobuf.GeneratedMessageV3 implements
			// @@protoc_insertion_point(message_implements:Base)
			BaseOrBuilder {
		// Use Base.newBuilder() to construct.
		private Base(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
			super(builder);
		}

		private Base() {
			type_ = "";
			stamp_ = 0L;
			signature_ = "";
		}

		@java.lang.Override
		public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
			return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
		}

		private Base(com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			this();
			int mutable_bitField0_ = 0;
			try {
				boolean done = false;
				while (!done) {
					int tag = input.readTag();
					switch (tag) {
					case 0:
						done = true;
						break;
					default: {
						if (!input.skipField(tag)) {
							done = true;
						}
						break;
					}
					case 10: {
						java.lang.String s = input.readStringRequireUtf8();

						type_ = s;
						break;
					}
					case 16: {

						stamp_ = input.readInt64();
						break;
					}
					case 26: {
						java.lang.String s = input.readStringRequireUtf8();

						signature_ = s;
						break;
					}
					case 34: {
						com.google.protobuf.Any.Builder subBuilder = null;
						if (data_ != null) {
							subBuilder = data_.toBuilder();
						}
						data_ = input.readMessage(com.google.protobuf.Any.parser(), extensionRegistry);
						if (subBuilder != null) {
							subBuilder.mergeFrom(data_);
							data_ = subBuilder.buildPartial();
						}

						break;
					}
					}
				}
			} catch (com.google.protobuf.InvalidProtocolBufferException e) {
				throw e.setUnfinishedMessage(this);
			} catch (java.io.IOException e) {
				throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
			} finally {
				makeExtensionsImmutable();
			}
		}

		public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
			return CeeetyBasePb.internal_static_Base_descriptor;
		}

		protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
			return CeeetyBasePb.internal_static_Base_fieldAccessorTable
					.ensureFieldAccessorsInitialized(CeeetyBasePb.Base.class, CeeetyBasePb.Base.Builder.class);
		}

		public static final int TYPE_FIELD_NUMBER = 1;
		private volatile java.lang.Object type_;

		/**
		 * <code>string type = 1;</code>
		 */
		public java.lang.String getType() {
			java.lang.Object ref = type_;
			if (ref instanceof java.lang.String) {
				return (java.lang.String) ref;
			} else {
				com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
				java.lang.String s = bs.toStringUtf8();
				type_ = s;
				return s;
			}
		}

		/**
		 * <code>string type = 1;</code>
		 */
		public com.google.protobuf.ByteString getTypeBytes() {
			java.lang.Object ref = type_;
			if (ref instanceof java.lang.String) {
				com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
				type_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		public static final int STAMP_FIELD_NUMBER = 2;
		private long stamp_;

		/**
		 * <code>int64 stamp = 2;</code>
		 */
		public long getStamp() {
			return stamp_;
		}

		public static final int SIGNATURE_FIELD_NUMBER = 3;
		private volatile java.lang.Object signature_;

		/**
		 * <code>string signature = 3;</code>
		 */
		public java.lang.String getSignature() {
			java.lang.Object ref = signature_;
			if (ref instanceof java.lang.String) {
				return (java.lang.String) ref;
			} else {
				com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
				java.lang.String s = bs.toStringUtf8();
				signature_ = s;
				return s;
			}
		}

		/**
		 * <code>string signature = 3;</code>
		 */
		public com.google.protobuf.ByteString getSignatureBytes() {
			java.lang.Object ref = signature_;
			if (ref instanceof java.lang.String) {
				com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
				signature_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		public static final int DATA_FIELD_NUMBER = 4;
		private com.google.protobuf.Any data_;

		/**
		 * <code>.google.protobuf.Any data = 4;</code>
		 */
		public boolean hasData() {
			return data_ != null;
		}

		/**
		 * <code>.google.protobuf.Any data = 4;</code>
		 */
		public com.google.protobuf.Any getData() {
			return data_ == null ? com.google.protobuf.Any.getDefaultInstance() : data_;
		}

		/**
		 * <code>.google.protobuf.Any data = 4;</code>
		 */
		public com.google.protobuf.AnyOrBuilder getDataOrBuilder() {
			return getData();
		}

		private byte memoizedIsInitialized = -1;

		public final boolean isInitialized() {
			byte isInitialized = memoizedIsInitialized;
			if (isInitialized == 1)
				return true;
			if (isInitialized == 0)
				return false;

			memoizedIsInitialized = 1;
			return true;
		}

		public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
			if (!getTypeBytes().isEmpty()) {
				com.google.protobuf.GeneratedMessageV3.writeString(output, 1, type_);
			}
			if (stamp_ != 0L) {
				output.writeInt64(2, stamp_);
			}
			if (!getSignatureBytes().isEmpty()) {
				com.google.protobuf.GeneratedMessageV3.writeString(output, 3, signature_);
			}
			if (data_ != null) {
				output.writeMessage(4, getData());
			}
		}

		public int getSerializedSize() {
			int size = memoizedSize;
			if (size != -1)
				return size;

			size = 0;
			if (!getTypeBytes().isEmpty()) {
				size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, type_);
			}
			if (stamp_ != 0L) {
				size += com.google.protobuf.CodedOutputStream.computeInt64Size(2, stamp_);
			}
			if (!getSignatureBytes().isEmpty()) {
				size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, signature_);
			}
			if (data_ != null) {
				size += com.google.protobuf.CodedOutputStream.computeMessageSize(4, getData());
			}
			memoizedSize = size;
			return size;
		}

		private static final long serialVersionUID = 0L;

		@java.lang.Override
		public boolean equals(final java.lang.Object obj) {
			if (obj == this) {
				return true;
			}
			if (!(obj instanceof CeeetyBasePb.Base)) {
				return super.equals(obj);
			}
			CeeetyBasePb.Base other = (CeeetyBasePb.Base) obj;

			boolean result = true;
			result = result && getType().equals(other.getType());
			result = result && (getStamp() == other.getStamp());
			result = result && getSignature().equals(other.getSignature());
			result = result && (hasData() == other.hasData());
			if (hasData()) {
				result = result && getData().equals(other.getData());
			}
			return result;
		}

		@java.lang.Override
		public int hashCode() {
			if (memoizedHashCode != 0) {
				return memoizedHashCode;
			}
			int hash = 41;
			hash = (19 * hash) + getDescriptor().hashCode();
			hash = (37 * hash) + TYPE_FIELD_NUMBER;
			hash = (53 * hash) + getType().hashCode();
			hash = (37 * hash) + STAMP_FIELD_NUMBER;
			hash = (53 * hash) + com.google.protobuf.Internal.hashLong(getStamp());
			hash = (37 * hash) + SIGNATURE_FIELD_NUMBER;
			hash = (53 * hash) + getSignature().hashCode();
			if (hasData()) {
				hash = (37 * hash) + DATA_FIELD_NUMBER;
				hash = (53 * hash) + getData().hashCode();
			}
			hash = (29 * hash) + unknownFields.hashCode();
			memoizedHashCode = hash;
			return hash;
		}

		public static CeeetyBasePb.Base parseFrom(java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static CeeetyBasePb.Base parseFrom(java.nio.ByteBuffer data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static CeeetyBasePb.Base parseFrom(com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static CeeetyBasePb.Base parseFrom(com.google.protobuf.ByteString data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static CeeetyBasePb.Base parseFrom(byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static CeeetyBasePb.Base parseFrom(byte[] data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static CeeetyBasePb.Base parseFrom(java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
		}

		public static CeeetyBasePb.Base parseFrom(java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
		}

		public static CeeetyBasePb.Base parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
		}

		public static CeeetyBasePb.Base parseDelimitedFrom(java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input,
					extensionRegistry);
		}

		public static CeeetyBasePb.Base parseFrom(com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
		}

		public static CeeetyBasePb.Base parseFrom(com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
		}

		public Builder newBuilderForType() {
			return newBuilder();
		}

		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.toBuilder();
		}

		public static Builder newBuilder(CeeetyBasePb.Base prototype) {
			return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
		}

		public Builder toBuilder() {
			return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
		}

		@java.lang.Override
		protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
			Builder builder = new Builder(parent);
			return builder;
		}

		/**
		 * <pre>
		 * 生成的数据访问类的类名
		 * </pre>
		 *
		 * Protobuf type {@code Base}
		 */
		public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
				// @@protoc_insertion_point(builder_implements:Base)
				CeeetyBasePb.BaseOrBuilder {
			public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
				return CeeetyBasePb.internal_static_Base_descriptor;
			}

			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
				return CeeetyBasePb.internal_static_Base_fieldAccessorTable
						.ensureFieldAccessorsInitialized(CeeetyBasePb.Base.class, CeeetyBasePb.Base.Builder.class);
			}

			// Construct using CeeetyBasePb.Base.newBuilder()
			private Builder() {
				maybeForceBuilderInitialization();
			}

			private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
				super(parent);
				maybeForceBuilderInitialization();
			}

			private void maybeForceBuilderInitialization() {
				if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
				}
			}

			public Builder clear() {
				super.clear();
				type_ = "";

				stamp_ = 0L;

				signature_ = "";

				if (dataBuilder_ == null) {
					data_ = null;
				} else {
					data_ = null;
					dataBuilder_ = null;
				}
				return this;
			}

			public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
				return CeeetyBasePb.internal_static_Base_descriptor;
			}

			public CeeetyBasePb.Base getDefaultInstanceForType() {
				return CeeetyBasePb.Base.getDefaultInstance();
			}

			public CeeetyBasePb.Base build() {
				CeeetyBasePb.Base result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			public CeeetyBasePb.Base buildPartial() {
				CeeetyBasePb.Base result = new CeeetyBasePb.Base(this);
				result.type_ = type_;
				result.stamp_ = stamp_;
				result.signature_ = signature_;
				if (dataBuilder_ == null) {
					result.data_ = data_;
				} else {
					result.data_ = dataBuilder_.build();
				}
				onBuilt();
				return result;
			}

			public Builder clone() {
				return (Builder) super.clone();
			}

			public Builder setField(com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
				return (Builder) super.setField(field, value);
			}

			public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
				return (Builder) super.clearField(field);
			}

			public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
				return (Builder) super.clearOneof(oneof);
			}

			public Builder setRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, int index,
					Object value) {
				return (Builder) super.setRepeatedField(field, index, value);
			}

			public Builder addRepeatedField(com.google.protobuf.Descriptors.FieldDescriptor field, Object value) {
				return (Builder) super.addRepeatedField(field, value);
			}

			public Builder mergeFrom(com.google.protobuf.Message other) {
				if (other instanceof CeeetyBasePb.Base) {
					return mergeFrom((CeeetyBasePb.Base) other);
				} else {
					super.mergeFrom(other);
					return this;
				}
			}

			public Builder mergeFrom(CeeetyBasePb.Base other) {
				if (other == CeeetyBasePb.Base.getDefaultInstance())
					return this;
				if (!other.getType().isEmpty()) {
					type_ = other.type_;
					onChanged();
				}
				if (other.getStamp() != 0L) {
					setStamp(other.getStamp());
				}
				if (!other.getSignature().isEmpty()) {
					signature_ = other.signature_;
					onChanged();
				}
				if (other.hasData()) {
					mergeData(other.getData());
				}
				onChanged();
				return this;
			}

			public final boolean isInitialized() {
				return true;
			}

			public Builder mergeFrom(com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
				CeeetyBasePb.Base parsedMessage = null;
				try {
					parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
				} catch (com.google.protobuf.InvalidProtocolBufferException e) {
					parsedMessage = (CeeetyBasePb.Base) e.getUnfinishedMessage();
					throw e.unwrapIOException();
				} finally {
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
				}
				return this;
			}

			private java.lang.Object type_ = "";

			/**
			 * <code>string type = 1;</code>
			 */
			public java.lang.String getType() {
				java.lang.Object ref = type_;
				if (!(ref instanceof java.lang.String)) {
					com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					type_ = s;
					return s;
				} else {
					return (java.lang.String) ref;
				}
			}

			/**
			 * <code>string type = 1;</code>
			 */
			public com.google.protobuf.ByteString getTypeBytes() {
				java.lang.Object ref = type_;
				if (ref instanceof String) {
					com.google.protobuf.ByteString b = com.google.protobuf.ByteString
							.copyFromUtf8((java.lang.String) ref);
					type_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			/**
			 * <code>string type = 1;</code>
			 */
			public Builder setType(java.lang.String value) {
				if (value == null) {
					throw new NullPointerException();
				}

				type_ = value;
				onChanged();
				return this;
			}

			/**
			 * <code>string type = 1;</code>
			 */
			public Builder clearType() {

				type_ = getDefaultInstance().getType();
				onChanged();
				return this;
			}

			/**
			 * <code>string type = 1;</code>
			 */
			public Builder setTypeBytes(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				checkByteStringIsUtf8(value);

				type_ = value;
				onChanged();
				return this;
			}

			private long stamp_;

			/**
			 * <code>int64 stamp = 2;</code>
			 */
			public long getStamp() {
				return stamp_;
			}

			/**
			 * <code>int64 stamp = 2;</code>
			 */
			public Builder setStamp(long value) {

				stamp_ = value;
				onChanged();
				return this;
			}

			/**
			 * <code>int64 stamp = 2;</code>
			 */
			public Builder clearStamp() {

				stamp_ = 0L;
				onChanged();
				return this;
			}

			private java.lang.Object signature_ = "";

			/**
			 * <code>string signature = 3;</code>
			 */
			public java.lang.String getSignature() {
				java.lang.Object ref = signature_;
				if (!(ref instanceof java.lang.String)) {
					com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					signature_ = s;
					return s;
				} else {
					return (java.lang.String) ref;
				}
			}

			/**
			 * <code>string signature = 3;</code>
			 */
			public com.google.protobuf.ByteString getSignatureBytes() {
				java.lang.Object ref = signature_;
				if (ref instanceof String) {
					com.google.protobuf.ByteString b = com.google.protobuf.ByteString
							.copyFromUtf8((java.lang.String) ref);
					signature_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			/**
			 * <code>string signature = 3;</code>
			 */
			public Builder setSignature(java.lang.String value) {
				if (value == null) {
					throw new NullPointerException();
				}

				signature_ = value;
				onChanged();
				return this;
			}

			/**
			 * <code>string signature = 3;</code>
			 */
			public Builder clearSignature() {

				signature_ = getDefaultInstance().getSignature();
				onChanged();
				return this;
			}

			/**
			 * <code>string signature = 3;</code>
			 */
			public Builder setSignatureBytes(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				checkByteStringIsUtf8(value);

				signature_ = value;
				onChanged();
				return this;
			}

			private com.google.protobuf.Any data_ = null;
			private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> dataBuilder_;

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public boolean hasData() {
				return dataBuilder_ != null || data_ != null;
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public com.google.protobuf.Any getData() {
				if (dataBuilder_ == null) {
					return data_ == null ? com.google.protobuf.Any.getDefaultInstance() : data_;
				} else {
					return dataBuilder_.getMessage();
				}
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public Builder setData(com.google.protobuf.Any value) {
				if (dataBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					data_ = value;
					onChanged();
				} else {
					dataBuilder_.setMessage(value);
				}

				return this;
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public Builder setData(com.google.protobuf.Any.Builder builderForValue) {
				if (dataBuilder_ == null) {
					data_ = builderForValue.build();
					onChanged();
				} else {
					dataBuilder_.setMessage(builderForValue.build());
				}

				return this;
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public Builder mergeData(com.google.protobuf.Any value) {
				if (dataBuilder_ == null) {
					if (data_ != null) {
						data_ = com.google.protobuf.Any.newBuilder(data_).mergeFrom(value).buildPartial();
					} else {
						data_ = value;
					}
					onChanged();
				} else {
					dataBuilder_.mergeFrom(value);
				}

				return this;
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public Builder clearData() {
				if (dataBuilder_ == null) {
					data_ = null;
					onChanged();
				} else {
					data_ = null;
					dataBuilder_ = null;
				}

				return this;
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public com.google.protobuf.Any.Builder getDataBuilder() {

				onChanged();
				return getDataFieldBuilder().getBuilder();
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			public com.google.protobuf.AnyOrBuilder getDataOrBuilder() {
				if (dataBuilder_ != null) {
					return dataBuilder_.getMessageOrBuilder();
				} else {
					return data_ == null ? com.google.protobuf.Any.getDefaultInstance() : data_;
				}
			}

			/**
			 * <code>.google.protobuf.Any data = 4;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder> getDataFieldBuilder() {
				if (dataBuilder_ == null) {
					dataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<com.google.protobuf.Any, com.google.protobuf.Any.Builder, com.google.protobuf.AnyOrBuilder>(
							getData(), getParentForChildren(), isClean());
					data_ = null;
				}
				return dataBuilder_;
			}

			public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
				return this;
			}

			public final Builder mergeUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
				return this;
			}

			// @@protoc_insertion_point(builder_scope:Base)
		}

		// @@protoc_insertion_point(class_scope:Base)
		private static final CeeetyBasePb.Base DEFAULT_INSTANCE;
		static {
			DEFAULT_INSTANCE = new CeeetyBasePb.Base();
		}

		public static CeeetyBasePb.Base getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		private static final com.google.protobuf.Parser<Base> PARSER = new com.google.protobuf.AbstractParser<Base>() {
			public Base parsePartialFrom(com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return new Base(input, extensionRegistry);
			}
		};

		public static com.google.protobuf.Parser<Base> parser() {
			return PARSER;
		}

		@java.lang.Override
		public com.google.protobuf.Parser<Base> getParserForType() {
			return PARSER;
		}

		public CeeetyBasePb.Base getDefaultInstanceForType() {
			return DEFAULT_INSTANCE;
		}

	}

	private static final com.google.protobuf.Descriptors.Descriptor internal_static_Base_descriptor;
	private static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_Base_fieldAccessorTable;

	public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
		return descriptor;
	}

	private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
	static {
		java.lang.String[] descriptorData = { "\n\022ceeetyBasePb.proto\032\031google/protobuf/an"
				+ "y.proto\"Z\n\004Base\022\014\n\004type\030\001 \001(\t\022\r\n\005stamp\030\002"
				+ " \001(\003\022\021\n\tsignature\030\003 \001(\t\022\"\n\004data\030\004 \001(\0132\024."
				+ "google.protobuf.Anyb\006proto3" };
		com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
			public com.google.protobuf.ExtensionRegistry assignDescriptors(
					com.google.protobuf.Descriptors.FileDescriptor root) {
				descriptor = root;
				return null;
			}
		};
		com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
				new com.google.protobuf.Descriptors.FileDescriptor[] { com.google.protobuf.AnyProto.getDescriptor(), },
				assigner);
		internal_static_Base_descriptor = getDescriptor().getMessageTypes().get(0);
		internal_static_Base_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_Base_descriptor, new java.lang.String[] { "Type", "Stamp", "Signature", "Data", });
		com.google.protobuf.AnyProto.getDescriptor();
	}

	// @@protoc_insertion_point(outer_class_scope)
}
