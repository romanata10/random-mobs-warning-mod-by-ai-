#!/usr/bin/env python3
"""Assembles tools/models.py from the helper header (models_head.py) and the spec file.

    python3 tools/build_models.py
"""
import os

HERE = os.path.dirname(os.path.abspath(__file__))

TAIL = '''

# --------------------------------------------------------------------- normalisation
def _relativize():
    """Spec files author every pivot in absolute model space; Minecraft wants nested
    pivots relative to their parent, so subtract the parent's absolute pivot once."""
    for spec in MOBS.values():
        authored = {p["name"]: tuple(p["pivot"]) for p in spec["parts"]}
        for p in spec["parts"]:
            parent = p.get("parent")
            if parent in authored:
                base = authored[parent]
                p["pivot"] = (authored[p["name"]][0] - base[0],
                              authored[p["name"]][1] - base[1],
                              authored[p["name"]][2] - base[2])


_relativize()
'''


def main():
    head = open(os.path.join(HERE, "models_head.py")).read().rstrip()
    specs = open(os.path.join(HERE, "models_specs.py")).read().strip()
    out = head + "\n\n\n" + specs + TAIL
    with open(os.path.join(HERE, "models.py"), "w") as fh:
        fh.write(out)
    print("models.py written (%d lines)" % len(out.splitlines()))


if __name__ == "__main__":
    main()
