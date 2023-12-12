
SUMMARY = "PostgreSQL database adapter for Python"
HOMEPAGE = "https://psycopg.org/psycopg/"
AUTHOR = "Daniele Varrazzo <daniele.varrazzo@gmail.com>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "postgresql"

SRC_URI += " \
           file://remove-pg-config.patch \
          "

PYPI_PACKAGE = "psycopg2"

#SRC_URI[md5sum] = "0f90af5f25b530e33d11ec24d737c3c3"
SRC_URI[sha256sum] = "d1454bde93fb1e224166811694d600e746430c006fbb031ea06ecc2ea41bf156"


inherit setuptools3 pypi


