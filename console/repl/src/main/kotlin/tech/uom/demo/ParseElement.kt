package tech.uom.demo

interface ParseElement

data class QuantityElement(val value: String, val unit: String) : ParseElement
