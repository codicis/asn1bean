/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.rspdefinitions;

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
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;

import com.beanit.asn1bean.compiler.pkix1explicit88.Certificate;
import com.beanit.asn1bean.compiler.pkix1explicit88.CertificateList;
import com.beanit.asn1bean.compiler.pkix1explicit88.Time;
import com.beanit.asn1bean.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class DeviceCapabilities implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	public VersionType gsmSupportedRelease = null;
	public VersionType utranSupportedRelease = null;
	public VersionType cdma2000onexSupportedRelease = null;
	public VersionType cdma2000hrpdSupportedRelease = null;
	public VersionType cdma2000ehrpdSupportedRelease = null;
	public VersionType eutranSupportedRelease = null;
	public VersionType contactlessSupportedRelease = null;
	public VersionType rspCrlSupportedVersion = null;
	
	public DeviceCapabilities() {
	}

	public DeviceCapabilities(byte[] code) {
		this.code = code;
	}

	public DeviceCapabilities(VersionType gsmSupportedRelease, VersionType utranSupportedRelease, VersionType cdma2000onexSupportedRelease, VersionType cdma2000hrpdSupportedRelease, VersionType cdma2000ehrpdSupportedRelease, VersionType eutranSupportedRelease, VersionType contactlessSupportedRelease, VersionType rspCrlSupportedVersion) {
		this.gsmSupportedRelease = gsmSupportedRelease;
		this.utranSupportedRelease = utranSupportedRelease;
		this.cdma2000onexSupportedRelease = cdma2000onexSupportedRelease;
		this.cdma2000hrpdSupportedRelease = cdma2000hrpdSupportedRelease;
		this.cdma2000ehrpdSupportedRelease = cdma2000ehrpdSupportedRelease;
		this.eutranSupportedRelease = eutranSupportedRelease;
		this.contactlessSupportedRelease = contactlessSupportedRelease;
		this.rspCrlSupportedVersion = rspCrlSupportedVersion;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (rspCrlSupportedVersion != null) {
			codeLength += rspCrlSupportedVersion.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 7
			reverseOS.write(0x87);
			codeLength += 1;
		}
		
		if (contactlessSupportedRelease != null) {
			codeLength += contactlessSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 6
			reverseOS.write(0x86);
			codeLength += 1;
		}
		
		if (eutranSupportedRelease != null) {
			codeLength += eutranSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 5
			reverseOS.write(0x85);
			codeLength += 1;
		}
		
		if (cdma2000ehrpdSupportedRelease != null) {
			codeLength += cdma2000ehrpdSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			reverseOS.write(0x84);
			codeLength += 1;
		}
		
		if (cdma2000hrpdSupportedRelease != null) {
			codeLength += cdma2000hrpdSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			reverseOS.write(0x83);
			codeLength += 1;
		}
		
		if (cdma2000onexSupportedRelease != null) {
			codeLength += cdma2000onexSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
		}
		
		if (utranSupportedRelease != null) {
			codeLength += utranSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
		}
		
		if (gsmSupportedRelease != null) {
			codeLength += gsmSupportedRelease.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			reverseOS.write(0x80);
			codeLength += 1;
		}
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
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
		if (lengthVal == 0) {
			return tlByteCount;
		}
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			gsmSupportedRelease = new VersionType();
			vByteCount += gsmSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			utranSupportedRelease = new VersionType();
			vByteCount += utranSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			cdma2000onexSupportedRelease = new VersionType();
			vByteCount += cdma2000onexSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			cdma2000hrpdSupportedRelease = new VersionType();
			vByteCount += cdma2000hrpdSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			cdma2000ehrpdSupportedRelease = new VersionType();
			vByteCount += cdma2000ehrpdSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			eutranSupportedRelease = new VersionType();
			vByteCount += eutranSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
			contactlessSupportedRelease = new VersionType();
			vByteCount += contactlessSupportedRelease.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
			rspCrlSupportedVersion = new VersionType();
			vByteCount += rspCrlSupportedVersion.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (gsmSupportedRelease != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("gsmSupportedRelease: ").append(gsmSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (utranSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("utranSupportedRelease: ").append(utranSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (cdma2000onexSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("cdma2000onexSupportedRelease: ").append(cdma2000onexSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (cdma2000hrpdSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("cdma2000hrpdSupportedRelease: ").append(cdma2000hrpdSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (cdma2000ehrpdSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("cdma2000ehrpdSupportedRelease: ").append(cdma2000ehrpdSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (eutranSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("eutranSupportedRelease: ").append(eutranSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (contactlessSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("contactlessSupportedRelease: ").append(contactlessSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (rspCrlSupportedVersion != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("rspCrlSupportedVersion: ").append(rspCrlSupportedVersion);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}
