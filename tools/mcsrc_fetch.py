#!/usr/bin/env python3
"""Fetch Minecraft 1.20.1 (mojmap-ish) sources from the public decompile mirror.

Usage:  python3 tools/mcsrc_fetch.py net/minecraft/world/level/block/DoorBlock.java ...
Saves into /tmp/mcsrc/<path with _>. Purely a development helper.
"""
import base64
import json
import os
import sys
import urllib.request

REPO = "Blackjack200/minecraft_client_1_20_1"
OUT = "/tmp/mcsrc"


def fetch(path: str) -> bool:
    url = f"https://api.github.com/repos/{REPO}/contents/{path}"
    req = urllib.request.Request(url, headers={"Accept": "application/vnd.github+json"})
    try:
        with urllib.request.urlopen(req, timeout=60) as r:
            data = json.load(r)
    except Exception as exc:  # noqa: BLE001
        print("FAIL", path, exc)
        return False
    if data.get("encoding") != "base64":
        print("FAIL", path, "not a file")
        return False
    text = base64.b64decode(data["content"]).decode("utf-8", "replace")
    os.makedirs(OUT, exist_ok=True)
    dest = os.path.join(OUT, path.replace("/", "_"))
    with open(dest, "w") as fh:
        fh.write(text)
    print("saved", dest, len(text))
    return True


if __name__ == "__main__":
    for p in sys.argv[1:]:
        fetch(p)
