/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.iso8823_presentation;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class ContextList implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class SEQUENCE implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static class TransferSyntaxNameList implements BerType, Serializable {

			private static final long serialVersionUID = 1L;

			public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
			public byte[] code = null;
			public List<TransferSyntaxName> seqOf = null;

			public TransferSyntaxNameList() {
				seqOf = new ArrayList<TransferSyntaxName>();
			}

			public TransferSyntaxNameList(byte[] code) {
				this.code = code;
			}

			public TransferSyntaxNameList(List<TransferSyntaxName> seqOf) {
				this.seqOf = seqOf;
			}

			public int encode(OutputStream reverseOS) throws IOException {
				return encode(reverseOS, true);
			}

			public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

				if (code != null) {
					for (int i = code.length - 1; i >= 0; i--) {
						reverseOS.write(code[i]);
					}
					if (withTag) {
						return tag.encode(reverseOS) + code.length;
					}
					return code.length;
				}

				int codeLength = 0;
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(reverseOS, true);
				}

				codeLength += BerLength.encodeLength(reverseOS, codeLength);

				if (withTag) {
					codeLength += tag.encode(reverseOS);
				}

				return codeLength;
			}

			public int decode(InputStream is) throws IOException {
				return decode(is, true);
			}

			public int decode(InputStream is, boolean withTag) throws IOException {
				int codeLength = 0;
				int subCodeLength = 0;
				BerTag berTag = new BerTag();
				if (withTag) {
					codeLength += tag.decodeAndCheck(is);
				}

				BerLength length = new BerLength();
				codeLength += length.decode(is);
				int totalLength = length.val;

				if (length.val == -1) {
					while (true) {
						subCodeLength += berTag.decode(is);

						if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
							int nextByte = is.read();
							if (nextByte != 0) {
								if (nextByte == -1) {
									throw new EOFException("Unexpected end of input stream.");
								}
								throw new IOException("Decoded sequence has wrong end of contents octets");
							}
							codeLength += subCodeLength + 1;
							return codeLength;
						}

						TransferSyntaxName element = new TransferSyntaxName();
						subCodeLength += element.decode(is, false);
						seqOf.add(element);
					}
				}
				while (subCodeLength < totalLength) {
					TransferSyntaxName element = new TransferSyntaxName();
					subCodeLength += element.decode(is, true);
					seqOf.add(element);
				}
				if (subCodeLength != totalLength) {
					throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

				}
				codeLength += subCodeLength;

				return codeLength;
			}

			public void encodeAndSave(int encodingSizeGuess) throws IOException {
				ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
				encode(reverseOS, false);
				code = reverseOS.getArray();
			}

			public String toString() {
				StringBuilder sb = new StringBuilder();
				appendAsString(sb, 0);
				return sb.toString();
			}

			public void appendAsString(StringBuilder sb, int indentLevel) {

				sb.append("{\n");
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				if (seqOf == null) {
					sb.append("null");
				}
				else {
					Iterator<TransferSyntaxName> it = seqOf.iterator();
					if (it.hasNext()) {
						sb.append(it.next());
						while (it.hasNext()) {
							sb.append(",\n");
							for (int i = 0; i < indentLevel + 1; i++) {
								sb.append("\t");
							}
							sb.append(it.next());
						}
					}
				}

				sb.append("\n");
				for (int i = 0; i < indentLevel; i++) {
					sb.append("\t");
				}
				sb.append("}");
			}

		}

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

		public byte[] code = null;
		public PresentationContextIdentifier presentationContextIdentifier = null;
		public AbstractSyntaxName abstractSyntaxName = null;
		public TransferSyntaxNameList transferSyntaxNameList = null;
		
		public SEQUENCE() {
		}

		public SEQUENCE(byte[] code) {
			this.code = code;
		}

		public SEQUENCE(PresentationContextIdentifier presentationContextIdentifier, AbstractSyntaxName abstractSyntaxName, TransferSyntaxNameList transferSyntaxNameList) {
			this.presentationContextIdentifier = presentationContextIdentifier;
			this.abstractSyntaxName = abstractSyntaxName;
			this.transferSyntaxNameList = transferSyntaxNameList;
		}

		public int encode(OutputStream reverseOS) throws IOException {
			return encode(reverseOS, true);
		}

		public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					reverseOS.write(code[i]);
				}
				if (withTag) {
					return tag.encode(reverseOS) + code.length;
				}
				return code.length;
			}

			int codeLength = 0;
			codeLength += transferSyntaxNameList.encode(reverseOS, true);
			
			codeLength += abstractSyntaxName.encode(reverseOS, true);
			
			codeLength += presentationContextIdentifier.encode(reverseOS, true);
			
			codeLength += BerLength.encodeLength(reverseOS, codeLength);

			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}

			return codeLength;

		}

		public int decode(InputStream is) throws IOException {
			return decode(is, true);
		}

		public int decode(InputStream is, boolean withTag) throws IOException {
			int tlByteCount = 0;
			int vByteCount = 0;
			BerTag berTag = new BerTag();

			if (withTag) {
				tlByteCount += tag.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			tlByteCount += length.decode(is);

			int lengthVal = length.val;
			vByteCount += berTag.decode(is);
			if (berTag.equals(PresentationContextIdentifier.tag)) {
				presentationContextIdentifier = new PresentationContextIdentifier();
				vByteCount += presentationContextIdentifier.decode(is, false);
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match the mandatory sequence element tag.");
			}
			
			if (berTag.equals(AbstractSyntaxName.tag)) {
				abstractSyntaxName = new AbstractSyntaxName();
				vByteCount += abstractSyntaxName.decode(is, false);
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match the mandatory sequence element tag.");
			}
			
			if (berTag.equals(TransferSyntaxNameList.tag)) {
				transferSyntaxNameList = new TransferSyntaxNameList();
				vByteCount += transferSyntaxNameList.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match the mandatory sequence element tag.");
			}
			
			if (lengthVal < 0) {
				if (!berTag.equals(0, 0, 0)) {
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				vByteCount += BerLength.readEocByte(is);
				return tlByteCount + vByteCount;
			}

			throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", actual sequence length: " + vByteCount);

		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS, false);
			code = reverseOS.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			sb.append("{");
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (presentationContextIdentifier != null) {
				sb.append("presentationContextIdentifier: ").append(presentationContextIdentifier);
			}
			else {
				sb.append("presentationContextIdentifier: <empty-required-field>");
			}
			
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (abstractSyntaxName != null) {
				sb.append("abstractSyntaxName: ").append(abstractSyntaxName);
			}
			else {
				sb.append("abstractSyntaxName: <empty-required-field>");
			}
			
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (transferSyntaxNameList != null) {
				sb.append("transferSyntaxNameList: ");
				transferSyntaxNameList.appendAsString(sb, indentLevel + 1);
			}
			else {
				sb.append("transferSyntaxNameList: <empty-required-field>");
			}
			
			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append("}");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
	public byte[] code = null;
	public List<SEQUENCE> seqOf = null;

	public ContextList() {
		seqOf = new ArrayList<SEQUENCE>();
	}

	public ContextList(byte[] code) {
		this.code = code;
	}

	public ContextList(List<SEQUENCE> seqOf) {
		this.seqOf = seqOf;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		for (int i = (seqOf.size() - 1); i >= 0; i--) {
			codeLength += seqOf.get(i).encode(reverseOS, true);
		}

		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();
		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);
		int totalLength = length.val;

		if (length.val == -1) {
			while (true) {
				subCodeLength += berTag.decode(is);

				if (berTag.tagNumber == 0 && berTag.tagClass == 0 && berTag.primitive == 0) {
					int nextByte = is.read();
					if (nextByte != 0) {
						if (nextByte == -1) {
							throw new EOFException("Unexpected end of input stream.");
						}
						throw new IOException("Decoded sequence has wrong end of contents octets");
					}
					codeLength += subCodeLength + 1;
					return codeLength;
				}

				SEQUENCE element = new SEQUENCE();
				subCodeLength += element.decode(is, false);
				seqOf.add(element);
			}
		}
		while (subCodeLength < totalLength) {
			SEQUENCE element = new SEQUENCE();
			subCodeLength += element.decode(is, true);
			seqOf.add(element);
		}
		if (subCodeLength != totalLength) {
			throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

		}
		codeLength += subCodeLength;

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (seqOf == null) {
			sb.append("null");
		}
		else {
			Iterator<SEQUENCE> it = seqOf.iterator();
			if (it.hasNext()) {
				it.next().appendAsString(sb, indentLevel + 1);
				while (it.hasNext()) {
					sb.append(",\n");
					for (int i = 0; i < indentLevel + 1; i++) {
						sb.append("\t");
					}
					it.next().appendAsString(sb, indentLevel + 1);
				}
			}
		}

		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

