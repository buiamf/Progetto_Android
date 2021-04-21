import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
}

buildscript {
    ext.room_version = '2.1.0-alpha01'
}