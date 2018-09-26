package com.shuframework.jdk7.lang;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test2() {
		String prefix = "[shu]";
		String oldFileName = "[shu]users.xls[shu]";
		int index = oldFileName.lastIndexOf(prefix);
		String newFileName = oldFileName.substring(0, index);
		System.out.println(newFileName);//adcadc
	}
	
	@Test
	public void test() {
		String str = "abcabc";
		str = str.replace('b', 'd');
		System.out.println(str);//adcadc
	}
	
	@Test
	public void getSuffix_test1() {
		String str = "aa.xls";
		String suffix = StringUtil.getSuffix(str);
		System.out.println(suffix);//xls
	}
	
	@Test
	public void getSuffixHasPoint_test1() {
		String str = "aa.xls";
		String suffix = StringUtil.getSuffixHasPoint(str);
		System.out.println(suffix);//.xls
	}
	
	@Test
	public void renameByAdd_test1() {
		String oldName = "aa.xls";
		String addName = "[shu]";
		String newName = StringUtil.renameByAdd(oldName, addName, StringUtil.TYPE_PREFIX);
		System.out.println(newName);//[shu]aa.xls
	}
	
	@Test
	public void renameByAdd_test2() {
		String oldName = "aa.xls";
		String addName = "[shu]";
		String newName = StringUtil.renameByAdd(oldName, addName, StringUtil.TYPE_SUFFIX);
		System.out.println(newName);//aa[shu].xls
	}
	
	@Test
	public void renameByAdd_test3() {
		String oldName = "bb";
		String addName = "[shu]";
		String newName = StringUtil.renameByAdd(oldName, addName, StringUtil.TYPE_PREFIX);
		System.out.println(newName);//[shu]bb
	}
	
	@Test
	public void renameByAdd_test4() {
		String oldName = "bb";
		String addName = "[shu]";
		String newName = StringUtil.renameByAdd(oldName, addName, StringUtil.TYPE_SUFFIX);
		System.out.println(newName);//bb[shu]
	}
	
	@Test
	public void renameByRemove_test1() {
		String oldName = "[shu]aa.xls";
		String addName = "[shu]";
		String newName = StringUtil.renameByRemove(oldName, addName, StringUtil.TYPE_PREFIX);
		System.out.println(newName);//aa.xls
	}
	
	@Test
	public void renameByRemove_test2() {
		String oldName = "aa[shu].xls";
		String addName = "[shu]";
		String newName = StringUtil.renameByRemove(oldName, addName, StringUtil.TYPE_SUFFIX);
		System.out.println(newName);//aa.xls
	}
	
	@Test
	public void renameByRemove_test3() {
		String oldName = "bb";
		String removeName = "[b]";
		String newName = StringUtil.renameByRemove(oldName, removeName, StringUtil.TYPE_PREFIX);
		System.out.println(newName);//
	}
	
	@Test
	public void renameByRemove_test4() {
		String oldName = "bb";
		String removeName = "[shu]";
		String newName = StringUtil.renameByRemove(oldName, removeName, StringUtil.TYPE_SUFFIX);
		System.out.println(newName);//bb[shu]
	}


	@Test
	public void capitalize_test() {
		String str = "abc_abC";
		System.out.println(StringUtil.capitalize(str));//Abc_abC
		System.out.println(StringUtil.capitalizeFully(str));//Abc_abc
	}

	@Test
	public void uncapitalize_test1() {
		String str = "AbCabC";
		System.out.println(StringUtil.uncapitalize(str));//abCabC
	}

	@Test
	public void capitalizeFully_test1() {
		String str = "abc_ABC_bcd";
		System.out.println(StringUtil.capitalizeFully(str, null));//Abc_abc_bcd
	}
	@Test
	public void capitalizeFully_test2() {
		String str = "abc_ABC_bcd";
		System.out.println(StringUtil.capitalizeFully(str, new char[]{'_'}));//AbcAbcBcd
	}
	@Test
	public void capitalizeFully_test3() {
		String str = "abc_ABC,bcd";
		System.out.println(StringUtil.capitalizeFully(str, new char[]{'_',','}));//AbcAbcBcd
	}

}
