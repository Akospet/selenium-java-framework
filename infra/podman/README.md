# Selenium Grid using Podman

This directory contains the infrastructure required to run a local Selenium Grid using Podman.

---

## Requirements

- Podman 5+
- Podman Machine (macOS)

---

## Start

```bash
./start-grid.sh
```

or directly

```bash
podman compose -f ../compose.yaml up -d
```

---

## Stop

```bash
./stop-grid.sh
```

or

```bash
podman compose down
```

---

## Verify

```bash
podman ps
```

You should see

```text
selenium-grid
```

Open

```
http://localhost:4444
```

The Selenium Grid dashboard should be displayed.

---

## Container

Current image

```
selenium/standalone-chrome:4.35.0
```

---

## Future roadmap

- Firefox node
- Edge node
- Multi-browser Grid
- Distributed Selenium Grid
- BrowserStack provider
