
## 我的自述

    我叫李君波，这是一个多么朴实的开场白啊，我毕业后工作了6年了。  
    发现自己平时遇到困难总是在逃避。之前干的是机械，后来转行计算机编程，就这样混着。  
    前段日子公司组织去巴厘岛旅游，回来之后，我的内心久久不能平静。  
    想想我这六年，无论时对待生活，还是对待工作，都是太过于浮躁。实在是有愧。  
    所以，我决定用两年的时间，去把计算机的世界搞得清清楚楚，然后转战文学。  
    http://wowubuntu.com/markdown/

如果你确实想要依赖 Markdown 来插入换行标签的话，在插入处先按入两个以上的空格然后回车  
如果你确实想要依赖 Markdown 来插入换行 标签的话，在插入处先按入两个以上的空格然后回车  

# 标题
---

标题-Setext 形式
===
标题-Setext 形式
---

# 标题-Atx 形式
## 标题-Atx 形式
### 标题-Atx 形式
#### 标题-Atx 形式
##### 标题-Atx 形式
###### 标题-Atx 形式

# 区块
---

## 区块引用 Blockquotes  

> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
> consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
> Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.
> 
> Donec sit amet nisl. Aliquam semper ipsum sit amet velit. Suspendisse
> id sem consectetuer libero luctus adipiscing.

## Markdown 也允许你偷懒只在整个段落的第一行最前面加上 > 

> This is a blockquote with two paragraphs. Lorem ipsum dolor sit amet,
consectetuer adipiscing elit. Aliquam hendrerit mi posuere lectus.
Vestibulum enim wisi, viverra nec, fringilla in, laoreet vitae, risus.

> Donec sit amet nisl. Aliquam semper ipsum sit amet velit. Suspendisse
id sem consectetuer libero luctus adipiscing.


## 区块引用可以嵌套（例如：引用内的引用），只要根据层次加上不同数量的 >

> This is the first level of quoting.
>
> > This is nested blockquote.
>
> Back to the first level.

## 引用的区块内也可以使用其他的 Markdown 语法，包括标题、列表、代码区块等

> ## 这是一个标题
> 
> 1.   这是第一行列表项。
> 2.   这是第二行列表项。
> 
> 给出一些例子代码：
> 
>     return shell_exec("echo $input | $markdown_script");


# 列表
---

## Markdown 支持有序列表和无序列表
 
### 无序列表使用星号、加号或是减号作为列表标记

 * Red
 * Green
 * Blue  
<br/>
 - Yellow
 - Black
 - White  
<br/>
 + Wiliam
 + Dream
 + Jack
 
### 有序列表则使用数字接着一个英文句点

1. Bird 
2. MaHale 
3. Parish

<ol>
<li>Bird</li>
<li>McHale</li>
<li>Parish</li>
</ol>

1.  Bird
1.  McHale
1.  Parish
3. Bird
1. McHale
8. Parish

*   Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
    Aliquam hendrerit mi posuere lectus. Vestibulum enim wisi,
    viverra nec, fringilla in, laoreet vitae, risus.
*   Donec sit amet nisl. Aliquam semper ipsum sit amet velit.
    Suspendisse id sem consectetuer libero luctus adipiscing.  
  
  
*   Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
Aliquam hendrerit mi posuere lectus. Vestibulum enim wisi,
viverra nec, fringilla in, laoreet vitae, risus.
*   Donec sit amet nisl. Aliquam semper ipsum sit amet velit.
Suspendisse id sem consectetuer libero luctus adipiscing.

1.  This is a list item with two paragraphs. Lorem ipsum dolor
    sit amet, consectetuer adipiscing elit. Aliquam hendrerit
    mi posuere lectus.

    Vestibulum enim wisi, viverra nec, fringilla in, laoreet
    vitae, risus. Donec sit amet nisl. Aliquam semper ipsum
    sit amet velit.

2.  Suspendisse id sem consectetuer libero luctus adipiscing.

## 如果要在列表项目内放进引用，那 > 就需要缩进

*   A list item with a blockquote:

    > This is a blockquote
    > inside a list item.  
    
## 如果要放代码区块的话，该区块就需要缩进两次，也就是 8 个空格或是 2 个制表符

*   一列表项包含一个列表区块：

        if(true){
        
        } else {
        
        }
        
1986\. What a great season.

# 代码区块
---

## 要在 Markdown 中建立代码区块很简单，只要简单地缩进 4 个空格或是 1 个制表符<br/>一个代码区块会一直持续到没有缩进的那一行（或是文件结尾）

这是一个普通段落：

    这是一个代码区块。
    
Here is an example of AppleScript:

    tell application "Foo"
        beep
    end tell
  
  
## 在代码区块里面， & 、 < 和 > 会自动转成 HTML 实体，这样的方式让你非常容易使用 Markdown 插入范例用的 HTML 原始码<br/>只需要复制贴上，再加上缩进就可以了，剩下的 Markdown 都会帮你处理

    <div class="footer">
        &copy; 2004 Foo Corporation
    </div>
    
## 代码区块中，一般的 Markdown 语法不会被转换，像是星号便只是星号，这表示你可以很容易地以 Markdown 语法撰写 Markdown 语法相关的文件

# 分隔线
---

## 你可以在一行中用三个以上的星号、减号、底线来建立一个分隔线，行内不能有其他东西

### 星号

***

### 下划线

___

### 减号

---

# 区段元素
---

## 链接
